package com.inz.projekat.service;


import com.inz.projekat.DTO.ResponseDTO;
import com.ugos.jiprolog.engine.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class RuleBasedService {

    private String corFile = "corpus.pl";

    @SuppressWarnings("Duplicates")
    private String getCorrect(String input){
        String out;
        int le = input.length()-1;
        out = input.subSequence(1,le).toString().replace('_',' ');
        return out;
    }

    private ResponseDTO prepare(String res, int type){
        ResponseDTO dto = new ResponseDTO();


            String[] mainSplit = res.split("\\|");

            String[] firstPart = mainSplit[0].split(",");
            String[] secondPart = mainSplit[1].split(",");

            dto.setCondition(firstPart[0].replace('_',' '));

            if (type == 0){
                dto.setNum(Integer.parseInt(firstPart[1]));
                dto.setProb(-1);
            }else if (type == 1){
                dto.setProb(Double.parseDouble(firstPart[1]));
                dto.setNum(-1);
            } else {
                dto.setProb((Double.parseDouble(firstPart[1])));
                dto.setNum((Integer.parseInt(firstPart[2]))); //doesn't exist if first two types
            }

            for(String a: secondPart){
                dto.getDecision().add(a.substring(1,a.length()-1).replace('_',' '));
            }

        return dto;
    }

    private JIPQuery consult(String term){
        System.out.println(term);
        JIPEngine engine = new JIPEngine();
        engine.consultFile(corFile);
        return engine.openSynchronousQuery(term);

    }
    @SuppressWarnings("Duplicates")
    public List<String> getTestForCondition(String condition){

        List<String> stringList = new ArrayList<>();

        JIPTerm solution;
        JIPQuery query = consult("test_for_condition('"+ condition.replace(' ','_') +"', Y)");
        while((solution = query.nextSolution()) != null){

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Y")){
                    stringList.add(getCorrect(var.getValue().toString()));
                }
            }
        }

        return stringList;
    }

    @SuppressWarnings("Duplicates")
    public List<String> getPreventionTests(Integer age, Boolean isMale, Boolean previousIllness){

        List<String> stringList = new ArrayList<>();

        JIPTerm solution;
        JIPQuery query = consult("preventive("+age +","+isMale.toString()+","+ previousIllness +" ,Res)");
        while((solution = query.nextSolution()) != null){

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Res")){
                    stringList.add(getCorrect(var.getValue().toString()));
                }
            }
        }

        return stringList;
    }

    @SuppressWarnings("Duplicates")
    public List<String> getTreatmentForCondition(String condition){
        List<String> stringList = new ArrayList<>();
        JIPTerm solution;
        JIPQuery query = consult("treatment_for_condition('"+ condition.replace(' ','_') +"', Y)");
        while((solution = query.nextSolution()) != null){

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Y")){
                    stringList.add(getCorrect(var.getValue().toString()));
                }
            }
        }
        return stringList;
    }

    private String getList(List<String> list){
        StringBuilder s = new StringBuilder();
        int i;
        for(i = 0; i < list.size() - 1; i++){
            s.append("'" + list.get(i).replace(' ','_') + "',");
        }
        s.append("'" + list.get(i).replace(' ','_') + "'");

        return  s.toString();
    }


    @SuppressWarnings("Duplicates")
    public List<ResponseDTO> getBestPerc(List<String> conditions, List<String> symptoms){
        List<ResponseDTO> stringList = new ArrayList<>();
        JIPTerm solution;
        JIPEngine engine = new JIPEngine();
        engine.consultFile(corFile);
        String term = "diagnose_perc(["+ getList(conditions)+"],["+ getList(symptoms)+"], Con,Prob, NumC, DecList)";
        JIPQuery query =  engine.openSynchronousQuery(term);
        while((solution = query.nextSolution()) != null){
            StringBuilder tmp = new StringBuilder();

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Con")){
                    String t1 = var.getValue().toString();
                    tmp.append(t1.substring(1,t1.length()-1));
                    tmp.append(',');
                }else if (var.getName().equalsIgnoreCase("Prob")){
                    tmp.append(var.getValue().toString());
                    tmp.append(',');
                } else if (var.getName().equalsIgnoreCase("NumC")){
                    tmp.append(var.getValue().toString());
                    tmp.append('|');
                }else if (var.getName().equalsIgnoreCase("DecList")){

                    for (JIPTerm termq : var.getVariables()){
                        String t1 = termq.getValue().toStringq(engine);
                        tmp.append(t1.substring(1,t1.length()-1));
                    }
               }
            }
            stringList.add(prepare(tmp.toString(),1));
        }
        return stringList;
    }

    @SuppressWarnings("Duplicates")
    public List<ResponseDTO> getBestPercSymptomOnly( List<String> symptoms){
        List<ResponseDTO> stringList = new ArrayList<>();
        JIPTerm solution;
        JIPEngine engine = new JIPEngine();
        engine.consultFile(corFile);
        String term = "best_by_percentage(["+ getList(symptoms)+"], Con,NumC, DecList)";
        JIPQuery query =  engine.openSynchronousQuery(term);
        while((solution = query.nextSolution()) != null){
            StringBuilder tmp = new StringBuilder();

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Con")){
                    String t1 = var.getValue().toString();
                    tmp.append(t1.substring(1,t1.length()-1));
                    tmp.append(',');
                }else if (var.getName().equalsIgnoreCase("NumC")){
                    tmp.append(var.getValue().toString());
                    tmp.append('|');
                }else if (var.getName().equalsIgnoreCase("DecList")){

                    for (JIPTerm termq : var.getVariables()){
                        String t1 = termq.getValue().toStringq(engine);
                        tmp.append(t1.substring(1,t1.length()-1));
                    }
                }
            }
            stringList.add(prepare(tmp.toString(),1));
        }
        return stringList;
    }
    @SuppressWarnings("Duplicates")
    public List<ResponseDTO> getBestNum(List<String> conditions, List<String> symptoms){
        List<ResponseDTO> stringList = new ArrayList<>();
        JIPTerm solution;
        JIPEngine engine = new JIPEngine();
        engine.consultFile(corFile);
        String term = "diagnose_number(["+ getList(conditions)+"],["+ getList(symptoms) + "] , Con,NumC, DecList)";
        JIPQuery query =  engine.openSynchronousQuery(term);
        while((solution = query.nextSolution()) != null){
            StringBuilder tmp = new StringBuilder();

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Con")){
                    String t1 = var.getValue().toString();
                    tmp.append(t1.substring(1,t1.length()-1));
                    tmp.append(',');
                }else if (var.getName().equalsIgnoreCase("NumC")){
                    tmp.append(var.getValue().toString());
                    tmp.append('|');
                }else if (var.getName().equalsIgnoreCase("DecList")){

                    for (JIPTerm termq : var.getVariables()){
                        String t1 = termq.getValue().toStringq(engine);
                        tmp.append(t1.substring(1,t1.length()-1));
                    }
                }
            }
            stringList.add(prepare(tmp.toString(),0));
        }
        return stringList;
    }



    @SuppressWarnings("Duplicates")
    public List<ResponseDTO> getBestNumSymptomOnly(List<String> conditions){
        List<ResponseDTO> stringList = new ArrayList<>();
        JIPTerm solution;
        JIPEngine engine = new JIPEngine();
        engine.consultFile(corFile);
        String term = "best_by_number(["+ getList(conditions)+"], Con,NumC, DecList)";
        JIPQuery query =  engine.openSynchronousQuery(term);
        while((solution = query.nextSolution()) != null){
            StringBuilder tmp = new StringBuilder();

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Con")){
                    String t1 = var.getValue().toString();
                    tmp.append(t1.substring(1,t1.length()-1));
                    tmp.append(',');
                }else if (var.getName().equalsIgnoreCase("NumC")){
                    tmp.append(var.getValue().toString());
                    tmp.append('|');
                }else if (var.getName().equalsIgnoreCase("DecList")){

                    for (JIPTerm termq : var.getVariables()){
                        String t1 = termq.getValue().toStringq(engine);
                        tmp.append(t1.substring(1,t1.length()-1));
                    }
                }
            }
            stringList.add(prepare(tmp.toString(),0));
        }
        return stringList;
    }

    @SuppressWarnings("Duplicates")
    public List<ResponseDTO> getAll(List<String> conditions){
        List<ResponseDTO> stringList = new ArrayList<>();
        JIPTerm solution;
        JIPEngine engine = new JIPEngine();
        engine.consultFile(corFile);
        String term = "number_of_symptoms(["+ getList(conditions)+"], Con, Prob, NumC, DecList)";
        JIPQuery query =  engine.openSynchronousQuery(term);
        while((solution = query.nextSolution()) != null){
            StringBuilder tmp = new StringBuilder();

            for (JIPVariable var : solution.getVariables()){
                if (var.getName().equalsIgnoreCase("Con")){
                    String t1 = var.getValue().toString();
                    tmp.append(t1.substring(1,t1.length()-1));
                    tmp.append(',');
                } else if (var.getName().equalsIgnoreCase("Prob")) {
                    tmp.append(var.getValue().toString());
                    tmp.append(',');
                }
                else if (var.getName().equalsIgnoreCase("NumC")){
                    tmp.append(var.getValue().toString());
                    tmp.append('|');
                }else if (var.getName().equalsIgnoreCase("DecList")){

                    for (JIPTerm termq : var.getVariables()){
                        String t1 = termq.getValue().toStringq(engine);
                        tmp.append(t1.substring(1,t1.length()-1));
                    }
                }
            }
            stringList.add(prepare(tmp.toString(),2));
        }
        return stringList;
    }



}

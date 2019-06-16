package com.inz.projekat.service;

import com.inz.projekat.DTO.BayesDTO;
import com.inz.projekat.DTO.ResponseDTO;
import com.inz.projekat.model.Patient;
import com.inz.projekat.repository.PatientRepo;
import com.inz.projekat.utils.Utils;
import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class RuleBasedService {


    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private Utils utils;

    public RuleBasedService() {
    }

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

            try {
                String[] secondPart = null;
//            if (mainSplit[1].contains(","))
                secondPart = mainSplit[1].split(",");

                dto.setCondition(firstPart[0].replace('_', ' '));

                if (type == 0) {
                    dto.setNum(Integer.parseInt(firstPart[1]));
                    dto.setProb(-1);
                } else if (type == 1) {
                    dto.setProb(Double.parseDouble(firstPart[1]));
                    dto.setNum(-1);
                } else {
                    dto.setProb((Double.parseDouble(firstPart[1])));
                    dto.setNum((Integer.parseInt(firstPart[2]))); //doesn't exist if first two types
                }
                if (secondPart != null)
                    for (String a : secondPart) {
                        dto.getDecision().add(a.substring(1, a.length() - 1).replace('_', ' '));
                    }
            }catch (Exception e){
                dto.setCondition(firstPart[0].replace('_', ' '));
                dto.setDecision(new ArrayList<>());
                dto.setProbBayes(0);
                dto.setProb(0);
                dto.setNum(0);
                return dto;
            }

        return dto;
    }

    private JIPQuery consult(String term){
        System.out.println(term);
        JIPEngine engine = utils.getJipEngine();
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


    public String prep(String nesto){
        nesto = nesto.replace(" ","_");
        nesto = nesto.replace(")", "");
        nesto = nesto.replace("(","");
        nesto = nesto.replace("-", "_");
        return nesto;
    }

    private ProbabilisticNode getSpecific(List<Node> allNodes, String name){
        for (Node n : allNodes){
            if (n.getName().equalsIgnoreCase(name))
                return (ProbabilisticNode) n;
        }
        return null;
    }

    public List<BayesDTO> calculateBayes(List<String> symptoms, List<String> negativeSymptoms, List<String> allConditions, Long id) throws Exception{
        BaseIO io = new NetIO();
        ProbabilisticNetwork net = null;

        List<BayesDTO> retList = new ArrayList<>();

        Patient p = patientRepo.findFirstById(id);
        if (p == null)
            throw new Exception("No id");

        List<String> repaired = new ArrayList<>();
        if (!negativeSymptoms.isEmpty()){
            for(String s : negativeSymptoms){
                if (!symptoms.contains(s)) // Can't be in both lists
                    repaired.add(prep(s)); // fix formatting for this part of code
            }
        }

        List<String> normalizedConditions = new ArrayList<>();
        for (String s : allConditions){
            normalizedConditions.add(prep(s));
        }

//        List<String> normalizedSymptoms = new ArrayList<>(); // if need be
//        for (String s : symptoms){
//            normalizedSymptoms.add(prep(s));
//        }

        try{
           net = (ProbabilisticNetwork) io.load(new File("final.net"));
                // Sex, Age for Patient metrics

            IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
            algorithm.setNetwork(net);
            algorithm.run();

            List<Node> nodes = net.getNodes();

            for (String s : symptoms){
//                ProbabilisticNode node = getSpecific(nodes, prep(s));
//                node.addFinding(0);
                ProbabilisticNode factNode = (ProbabilisticNode)net.getNode(prep(s));
                int stateIndex = 1; // index of state "green"

                for (int i = 0; i < factNode.getStatesSize(); i++){
                    System.out.println(factNode.getStateAt(i));
                }
                factNode.addFinding(stateIndex);
            }

            System.out.println("Symptoms done");
            if (!repaired.isEmpty())
            for (String s : repaired){ // Set negative symptoms to false
                        try {
                            ProbabilisticNode node = (ProbabilisticNode) net.getNode(s);
                            node.addFinding(1);
                        }catch (Exception e){
                            System.out.println(s);
                            e.printStackTrace();
                        }
            }
            System.out.println("Negative symptoms done");

            ProbabilisticNode node1 = (ProbabilisticNode)net.getNode("Sex");
            ProbabilisticNode node2 = (ProbabilisticNode)net.getNode("Age");

            node1.addFinding(p.getGender() == 'm' ? 0 : 1);
            node2.addFinding(p.getAge() > 18 ? 0 : 1);


            try {
                net.updateEvidences();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            for (Node node : nodes){

                System.out.println("ID:" + node.getName());

                //Boolean alreadySeenSymptom = symptoms.contains(node.getName());
                Boolean isACondition = normalizedConditions.contains(node.getName());
                //Boolean isSex = node.getName().equalsIgnoreCase("Sex");
                //Boolean isAge = node.getName().equalsIgnoreCase("Age");
                //if (!( alreadySeenSymptom || isACondition || isSex || isAge)) {
                if (isACondition){
                    System.out.println("ID:" + node.getName());
                    System.out.println(node.getStateAt(0)+ ":" + ((ProbabilisticNode)node).getMarginalAt(0));
                    double ne =  ((ProbabilisticNode)node).getMarginalAt(0);
                    ne = Math.round(ne *100.0)/100.0;
                    retList.add(new BayesDTO(node.getName(),ne));
                }


            }

//
//            for (Node node : nodes){
//                for (int i = 0; i < node.getStatesSize(); i++) {
//                    System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode)node).getMarginalAt(i));
//                }
//            }


        }catch (IOException e){
            e.printStackTrace();
        }
        return retList;
    }



    @SuppressWarnings("Duplicates")
    public List<ResponseDTO> getBestPerc(List<String> conditions, List<String> symptoms){
        List<ResponseDTO> stringList = new ArrayList<>();
        JIPTerm solution;
        JIPEngine engine = utils.getJipEngine();
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
        JIPEngine engine = utils.getJipEngine();
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
        JIPEngine engine = utils.getJipEngine();
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
        JIPEngine engine = utils.getJipEngine();
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
        JIPEngine engine = utils.getJipEngine();
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

package com.inz.projekat.service;

import com.inz.projekat.model.Condition;
import com.inz.projekat.model.Patient;
import com.inz.projekat.repository.ConditionRepo;
import com.inz.projekat.repository.PatientRepo;
import com.inz.projekat.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;


@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class GeneralService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private Utils utils;

    public GeneralService() {
    }

    @SuppressWarnings("Duplicates")
    private String getCorrect(String input){
        String out;
        int le = input.length()-1;
        out = input.subSequence(1,le).toString().replace('_',' ');
        return out;
    }

    public Boolean delete(Long id){

        Patient p = patientRepo.findFirstById(id);
       if (p != null){
           patientRepo.delete(p);
           return true;
       }
       return  false;
    }





    public List<String> getAllSymptoms(){

        JIPEngine engine = utils.getJipEngine();
        JIPQuery query = engine.openSynchronousQuery("symptom(X)");

        // pravila se mogu dodavati i tokom izvrsavanja (u runtime-u)
        // assertz dodaje pravilo na kraj programa (aasserta dodaje na pocetak programa), na primer:
        // engine.assertz(engine.getTermParser().parseTerm("sledbenik(X,Y) :- X is Y+1."));

        List<String> symptomList = new ArrayList<String>();
        JIPTerm solution;
        while ( (solution = query.nextSolution()) != null) {

            for (JIPVariable var: solution.getVariables()) {

                // Only one variable
                if (var != null){
              //      System.out.println(var.getName() + "=" + var.getValue());
                    symptomList.add(getCorrect(var.getValue().toString()));
                }

            }
        }

        return symptomList;
    }

    @SuppressWarnings("Duplicates")

    public List<String> getAllConditions(){

        JIPEngine engine = utils.getJipEngine();
        JIPQuery query = engine.openSynchronousQuery("condition(X, Y)");

        List<String> condList = new ArrayList<>();
        JIPTerm solution;
        while ( (solution = query.nextSolution()) != null) {
            //System.out.println("solution: " + solution);
            for (JIPVariable var: solution.getVariables()) {
                if (var.getName().equalsIgnoreCase("X")){
                    condList.add(getCorrect(var.getValue().toString()));
                }
            }
        }

        return condList;
    }

    @SuppressWarnings("Duplicates")

    public List<String> getAllTests(){
        JIPEngine engine = utils.getJipEngine();
        JIPQuery query = engine.openSynchronousQuery("test(X)");

        List<String> condList = new ArrayList<>();
        JIPTerm solution;
        while ( (solution = query.nextSolution()) != null) {
            //System.out.println("solution: " + solution);
            for (JIPVariable var: solution.getVariables()) {
                if (var.getName().equalsIgnoreCase("X")){
                    condList.add(getCorrect(var.getValue().toString()));
                }
            }
        }

        return condList;
    }

    @SuppressWarnings("Duplicates")

    public List<String> getAllTreatments(){
        JIPEngine engine = utils.getJipEngine();
        JIPQuery query = engine.openSynchronousQuery("treatment(X)");

        List<String> condList = new ArrayList<>();
        JIPTerm solution;
        while ( (solution = query.nextSolution()) != null) {
            //System.out.println("solution: " + solution);
            for (JIPVariable var: solution.getVariables()) {
                if (var.getName().equalsIgnoreCase("X")){
                    condList.add(getCorrect(var.getValue().toString()));
                }
            }
        }

        return condList;
    }

    @SuppressWarnings("Duplicates")
    public Patient addPatient(Patient insert){

        Patient a = new Patient();
        a.setAge(insert.getAge());

        List<Condition> list = a.getConditions();


        for(Condition c : insert.getConditions()){
            Condition q = conditionRepo.findByName(c.getName());
            if (q == null){
                Condition n = new Condition();
                n.setName(c.getName());
                conditionRepo.save(n);
                list.add(n);
            }
            else
                list.add(q);
        }

        a.setName(insert.getName());
        a.setLastName(insert.getLastName());
        a.setGender(insert.getGender());
        patientRepo.save(a);
        return a;
    }

    @SuppressWarnings("Duplicates")
    public Patient update(Patient forUpdate){

        Patient p = patientRepo.findFirstById(forUpdate.getId());

        if (p != null){
            p.setLastName(forUpdate.getLastName());
            p.setName(forUpdate.getName());
            p.setAge(forUpdate.getAge());
            p.setGender(forUpdate.getGender());
            p.setConditions(null);
            List<Condition> list = new ArrayList<>();

            for(Condition c : forUpdate.getConditions()){
                Condition q = conditionRepo.findByName(c.getName());
                if (q == null){
                    Condition n = new Condition();
                    n.setName(c.getName());
                    conditionRepo.save(n);
                    list.add(n);
                }
                else
                    list.add(q);
            }

            p.setConditions(list);
            p.setGender(forUpdate.getGender());
            patientRepo.save(p);
        }


        return p;
    }


    public List<Patient> listAllPatients(){
        return patientRepo.findAll();
    }

    public Patient getPatient(Long id){
        return patientRepo.findFirstById(id);
    }


}

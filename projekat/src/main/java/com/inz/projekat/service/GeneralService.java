package com.inz.projekat.service;

import com.inz.projekat.model.Patient;
import com.inz.projekat.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;


@Service
public class GeneralService {

    @Autowired
    private PatientRepo patientRepo;

    @SuppressWarnings("Duplicates")
    private String getCorrect(String input){
        String out;
        int le = input.length()-1;
        out = input.subSequence(1,le).toString().replace('_',' ');
        return out;
    }

    public List<String> getAllSymptoms(){

        JIPEngine engine = new JIPEngine();

        engine.consultFile("corpus.pl");
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

        JIPEngine engine = new JIPEngine();

        engine.consultFile("corpus.pl");
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
        JIPEngine engine = new JIPEngine();

        engine.consultFile("corpus.pl");
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

    public Patient addPatient(Patient insert){

        Patient a = new Patient();
        a.setAge(insert.getAge());
        a.setConditions(insert.getConditions());
        a.setName(insert.getName());
        a.setLastName(insert.getLastName());
        a.setMale(insert.isMale());
        patientRepo.save(a);
        return a;
    }

    public List<Patient> listAllPatients(){
        return patientRepo.findAll();
    }

    public Patient getPatient(Long id){
        return patientRepo.findFirstById(id);
    }


}

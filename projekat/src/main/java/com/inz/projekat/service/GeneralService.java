package com.inz.projekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;


@Service
public class GeneralService {


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
            System.out.println("solution: " + solution);
            for (JIPVariable var: solution.getVariables()) {
                //System.out.println(var.getName() + "=" + var.getValue());
                // Only one variable
                symptomList.add(var.getValue().toString());
            }
        }

        return symptomList;
    }

    public List<String> getAllConditions(){

        JIPEngine engine = new JIPEngine();

        engine.consultFile("corpus.pl");
        JIPQuery query = engine.openSynchronousQuery("condition(X, Y)");

        List<String> symptomList = new ArrayList<String>();
        JIPTerm solution;
        while ( (solution = query.nextSolution()) != null) {
            System.out.println("solution: " + solution);
            for (JIPVariable var: solution.getVariables()) {
                if (var.getName().equalsIgnoreCase("X")){
                    symptomList.add(var.getValue().toString());
                }
            }
        }

        return symptomList;
    }




}

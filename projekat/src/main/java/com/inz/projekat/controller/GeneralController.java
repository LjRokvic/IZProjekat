package com.inz.projekat.controller;

import com.inz.projekat.model.Patient;
import com.inz.projekat.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value = "/condition",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getAllConditions(){
        return generalService.getAllConditions();
    }

    @RequestMapping(value = "/symptom", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getAllSymptoms(){
        return generalService.getAllSymptoms();
    }

    @RequestMapping(value = "/test", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getAllTests(){
        return generalService.getAllTests();
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Patient addPatient(Patient patient){
        return generalService.addPatient(patient);
    }

    @RequestMapping(value = "/patient/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Patient getPatient(@PathVariable  Long id){
        return generalService.getPatient(id);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Patient> getAllPatients(){
        return generalService.listAllPatients();
    }


}

package com.inz.projekat.controller;

import com.inz.projekat.model.Patient;
import com.inz.projekat.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/patient", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Patient addPatient(@RequestBody Patient patient){
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

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePatient(@PathVariable Long id)
    {
        if (generalService.delete(id)){
            return ResponseEntity.ok().build();
        }else {
           return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/patient", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Patient updatePatient(@RequestBody Patient patient){
        return generalService.update(patient);
    }

    @RequestMapping(value = "/treatment", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getAllTreatments(){
        return generalService.getAllTreatments();
    }

}

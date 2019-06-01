package com.inz.projekat.controller;


import com.inz.projekat.DTO.DataDTO;
import com.inz.projekat.DTO.ResponseDTO;
import com.inz.projekat.service.RuleBasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RuleBasedController {

    @Autowired
    private RuleBasedService ruleBasedService;

    @RequestMapping(value = "/test/{condition}")
    public List<String> getTestForCondition(@PathVariable String condition){
        return ruleBasedService.getTestForCondition(condition);
    }

    @RequestMapping(value = "/treatment/{condition}")
    public List<String> getListOfTreatments(@PathVariable String condition){
        return ruleBasedService.getTreatmentForCondition(condition);
    }

    @RequestMapping(value = "/best/perc", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ResponseDTO> getBestPerc(@RequestBody List<String> symptoms){

        return ruleBasedService.getBestPercSymptomOnly(symptoms); // only 1 in List
    }

    @RequestMapping(value = "/best/num", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ResponseDTO> getBestNum(@RequestBody List<String> symptoms){
        return ruleBasedService.getBestNumSymptomOnly(symptoms);
    }

    @RequestMapping(value = "/best/num/conditions", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ResponseDTO> getBestNumWithConditions(@RequestBody DataDTO data){
        return ruleBasedService.getBestNum(data.getConditions(), data.getSymptoms());
    }
    @RequestMapping(value = "/best/perc/conditions", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ResponseDTO> getBestPercWithConditions(@RequestBody DataDTO data){
        return ruleBasedService.getBestPerc(data.getConditions(),data.getSymptoms());
    }

    @RequestMapping(value = "/all", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ResponseDTO> getAll(@RequestBody List<String> symptoms){
        return ruleBasedService.getAll(symptoms);
    }

    @RequestMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getPreventive(Integer age, Boolean isMale, Boolean previousIll){
        return ruleBasedService.getPreventionTests(age,isMale,previousIll);
    }

}

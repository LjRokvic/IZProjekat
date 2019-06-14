package com.inz.projekat.controller;


import com.inz.projekat.DTO.BayesDTO;
import com.inz.projekat.DTO.DataDTO;
import com.inz.projekat.DTO.ResponseDTO;
import com.inz.projekat.service.GeneralService;
import com.inz.projekat.service.RuleBasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RuleBasedController {

    @Autowired
    private GeneralService generalService;

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

    @RequestMapping(value = "/all/{id}", method = RequestMethod.POST ,consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ResponseDTO> getAll(@RequestBody List<String> symptoms, @PathVariable("id") Long patientId){

        List<ResponseDTO> results =  ruleBasedService.getAll(symptoms);
        try{
            List<BayesDTO> retList =  ruleBasedService.calculateBayes(symptoms, generalService.getAllSymptoms(), patientId);
            int ind;
            for (ResponseDTO d : results){
                ind = -1;
                ind = retList.indexOf(new BayesDTO(ruleBasedService.prep(d.getCondition()),0.0));
                if (ind != -1){
                    d.setProbBayes(retList.get(ind).getProb());
                }else{
                    System.out.println("EXTRAFOUND:"+ d.getCondition());
                }
            }
//            Comparator<ResponseDTO> com1 = new Comparator<ResponseDTO>() {
//                @Override
//                public int compare(ResponseDTO o1, ResponseDTO o2) {
//                    return Double.compare(o2.getProbBayes(), o1.getProbBayes());
//                }
//            };
//            results.sort(com1);
            results.sort(Comparator.comparingDouble(ResponseDTO::getProbBayes)); //(ResponseDTO::getProb).reversed().thenComparingInt(ResponseDTO::getNum).reversed());
            System.out.println(retList.size());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return results;
    }

    @RequestMapping(value = "/allPreventive/{age}/{isMale}/{previousIll}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getPreventive(@PathVariable Integer age,@PathVariable Boolean isMale,@PathVariable Boolean previousIll){
        return ruleBasedService.getPreventionTests(age,isMale,previousIll);
    }



}

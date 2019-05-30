package com.inz.projekat.controller;

import com.inz.projekat.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value = "/condition",method = RequestMethod.GET)
    public List<String> getAllConditions(){
        return generalService.getAllConditions();
    }

    @RequestMapping(value = "/symptom")
    public List<String> getAllSymptoms(){
        return generalService.getAllSymptoms();
    }

}

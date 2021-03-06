package com.inz.projekat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inz.projekat.DTO.CaseTableDTO;
import com.inz.projekat.DTO.PreventiveTableDTO;
import com.inz.projekat.model.Condition;
import com.inz.projekat.model.Patient;
import com.inz.projekat.model.dto.CaseDescription;
import com.inz.projekat.model.dto.PreventiveDescription;
import com.inz.projekat.repository.ConditionRepo;
import com.inz.projekat.repository.PatientRepo;
import com.inz.projekat.service.CaseBasedService;

@RestController
@RequestMapping(value = "/cbr/evaluate")
public class CaseBasedController {
	
    @Autowired
    private CaseBasedService caseBasedService;
    
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private ConditionRepo conditionRepo;
    
    @RequestMapping(value = "case",method = RequestMethod.POST)
    public List<CaseTableDTO> getBestCases(@RequestParam("id") Long id, @RequestBody CaseDescription cD){
    	Patient p = patientRepo.findById(id).get();

    	cD.setAge(p.getAge());
    	cD.setGender(p.getGender());

    	
    	return caseBasedService.getMatches(cD);
    }
    
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void addEntry(@RequestParam("id") Long id, @RequestBody CaseDescription cD){
    	
    	Patient p = patientRepo.findById(id).get();

    	cD.setAge(p.getAge());
    	cD.setGender(p.getGender());
    	
    	try {
			caseBasedService.addEntry(cD);

    		Condition con = conditionRepo.findByName(cD.getCondition());
    		
    		if(con == null) {
    			con = new Condition(cD.getCondition());
    			conditionRepo.save(con);
    		}
    		
    		if(!p.getConditions().contains(con)) {
    			p.getConditions().add(con);
    			patientRepo.save(p);
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value = "preventive",method = RequestMethod.POST)
    public List<PreventiveTableDTO> getBestPreventive(@RequestParam("id") Long id, @RequestBody PreventiveDescription pD){
    	Patient p = patientRepo.findById(id).get();
    	ArrayList<String> pastC = new ArrayList<String>();
    	
    	for(Condition c : p.getConditions()) {
    		pastC.add(c.getName());
    	}
    	
    	
    	pD.setAge(p.getAge());
    	pD.setGender(p.getGender());
    	pD.setPastConditions(pastC);

    	
    	return caseBasedService.getPreventiveMatches(pD);
    }
    
    @RequestMapping(value = "addPreventive",method = RequestMethod.POST)
    public void addPreventive(@RequestParam("id") Long id, @RequestBody PreventiveDescription pD){
    	Patient p = patientRepo.findById(id).get();
    	ArrayList<String> pastC = new ArrayList<String>();
    	
    	for(Condition c : p.getConditions()) {
    		pastC.add(c.getName());
    	}
    	
    	
    	pD.setAge(p.getAge());
    	pD.setGender(p.getGender());
    	pD.setPastConditions(pastC);
    	

    	
    	try {
			caseBasedService.addPreventiveEntry(pD);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}

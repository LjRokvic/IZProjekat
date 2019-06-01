package com.inz.projekat.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inz.projekat.model.dto.CaseDescription;
import com.inz.projekat.model.dto.CaseTableDTO;
import com.inz.projekat.model.dto.PreventiveContainer;
import com.inz.projekat.model.dto.PreventiveDescription;
import com.inz.projekat.service.CaseBasedService;

@RestController
@RequestMapping(value = "/cbr/evaluate")
public class CaseBasedController {
	
    @Autowired
    private CaseBasedService caseBasedService;
	
    @RequestMapping(value = "case",method = RequestMethod.POST)
    public List<CaseTableDTO> getBestCases(@RequestBody CaseDescription cD){
    	
    	return caseBasedService.getMatches(cD);
    }
    
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void addEntry(@RequestParam("id") int id, @RequestBody CaseDescription cD){
    	
    	try {
			caseBasedService.addEntry(cD);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping(value = "preventive",method = RequestMethod.GET)
    public PreventiveContainer getBestPreventive(@RequestBody PreventiveDescription pD){
    	
    	return caseBasedService.getPreventiveMatches(pD);
    }
    
    @RequestMapping(value = "preventive",method = RequestMethod.POST)
    public void addPreventive(@RequestBody PreventiveDescription pD){
    	
    	try {
			caseBasedService.addPreventiveEntry(pD);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}

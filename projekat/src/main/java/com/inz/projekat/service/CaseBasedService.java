package com.inz.projekat.service;


import java.io.IOException;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.inz.projekat.model.dto.CaseContainer;
import com.inz.projekat.model.dto.CaseDescription;
import com.inz.projekat.model.dto.PreventiveContainer;
import com.inz.projekat.model.dto.PreventiveDescription;

import cbr.ConditionCBR;
import cbr.PreventiveCBR;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

@Service
public class CaseBasedService {


	public CaseContainer getMatches(CaseDescription cD) {
		
		ConditionCBR cbr = new ConditionCBR();
		
		Collection<RetrievalResult> eval = cbr.evaluateCase(cD);
		eval = SelectCases.selectTopKRR(eval, 5);
		
		CaseContainer cC = new CaseContainer();
		
		for (RetrievalResult nse : eval) {
			cC.getCases().add((CaseDescription) nse.get_case().getDescription());
		}
		

		return cC;
	}
	
	public void addEntry(CaseDescription cD) throws IOException {
		
		ConditionCBR cbr = new ConditionCBR();
		cbr.addEntry(cD);

	}
	
	public PreventiveContainer getPreventiveMatches(PreventiveDescription pD) {
		
		PreventiveCBR cbr = new PreventiveCBR();
		
		Collection<RetrievalResult> eval = cbr.evaluateCase(pD);
		eval = SelectCases.selectTopKRR(eval, 5);
		
		PreventiveContainer pC = new PreventiveContainer();
		
		for (RetrievalResult nse : eval) {
			pC.getCases().add((PreventiveDescription) nse.get_case().getDescription());
		}
		

		return pC;
	}
	
	public void addPreventiveEntry(PreventiveDescription pD) throws IOException {
		
		PreventiveCBR cbr = new PreventiveCBR();
		cbr.addEntry(pD);

	}

}

package com.inz.projekat.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inz.projekat.cbr.ConditionCBR;
import com.inz.projekat.cbr.PreventiveCBR;
import com.inz.projekat.model.dto.CaseDescription;
import com.inz.projekat.model.dto.CaseTableDTO;
import com.inz.projekat.model.dto.PreventiveContainer;
import com.inz.projekat.model.dto.PreventiveDescription;

import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

@Service
public class CaseBasedService {


	public List<CaseTableDTO> getMatches(CaseDescription cD) {
		
		ConditionCBR cbr = new ConditionCBR();
		
		Collection<RetrievalResult> eval = cbr.evaluateCase(cD);
		eval = SelectCases.selectTopKRR(eval, 5);
		
		ArrayList<CaseTableDTO> res = new ArrayList<CaseTableDTO>();
		int i = 1;
		for (RetrievalResult nse : eval) {
			CaseTableDTO nDTO = new CaseTableDTO();
			
			nDTO.setNumber(i);
			nDTO.setTests(((CaseDescription) nse.get_case().getDescription()).getTests());
			nDTO.setDiagnosis(((CaseDescription) nse.get_case().getDescription()).getCondition());
			nDTO.setTreatments(((CaseDescription) nse.get_case().getDescription()).getTreatments());
			nDTO.setSimilarity(String.format ("%.2f", nse.getEval()*100)+"%");
			res.add(nDTO);
			i++;
		}
		

		return res;
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

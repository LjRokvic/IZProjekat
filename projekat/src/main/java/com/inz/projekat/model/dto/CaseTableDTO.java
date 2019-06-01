package com.inz.projekat.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CaseTableDTO {
	
	private int number;
	private String similarity;
	private List<String> tests = new ArrayList<String>();
	private String diagnosis;
	private List<String> treatments = new ArrayList<String>();
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSimilarity() {
		return similarity;
	}
	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}
	public List<String> getTests() {
		return tests;
	}
	public void setTests(List<String> tests) {
		this.tests = tests;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public List<String> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<String> treatments) {
		this.treatments = treatments;
	}
	
	
	

}

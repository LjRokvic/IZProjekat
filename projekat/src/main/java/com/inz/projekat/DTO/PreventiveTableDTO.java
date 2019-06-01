package com.inz.projekat.DTO;

import java.util.List;

public class PreventiveTableDTO {
	private int number;
	private String similarity;
	private List<String> preventiveTests;
	
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
	public List<String> getPreventiveTests() {
		return preventiveTests;
	}
	public void setPreventiveTests(List<String> preventiveTests) {
		this.preventiveTests = preventiveTests;
	}
	
	

}

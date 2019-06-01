package com.inz.projekat.model.dto;

import java.util.ArrayList;
import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class PreventiveDescription implements CaseComponent {
	
	
	private char gender;
	private int age;

	private List<String> pastConditions = new ArrayList<String>();
	private List<String> familyHistory = new ArrayList<String>();
	private List<String> otherRiskFactors = new ArrayList<String>();
	
	private List<String> recommendedPreventiveTests = new ArrayList<String>();

	@Override
	public Attribute getIdAttribute() {
		return null;
	}
	
	

	@Override
	public String toString() {
		return "PreventiveDescription [gender=" + gender + ", age=" + age + ", pastConditions=" + pastConditions
				+ ", familyHistory=" + familyHistory + ", otherRiskFactors=" + otherRiskFactors
				+ ", recommendedPreventiveTests=" + recommendedPreventiveTests + "]";
	}



	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getPastConditions() {
		return pastConditions;
	}

	public void setPastConditions(List<String> pastConditions) {
		this.pastConditions = pastConditions;
	}

	public List<String> getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(List<String> familyHistory) {
		this.familyHistory = familyHistory;
	}

	public List<String> getOtherRiskFactors() {
		return otherRiskFactors;
	}

	public void setOtherRiskFactors(List<String> otherRiskFactors) {
		this.otherRiskFactors = otherRiskFactors;
	}

	public List<String> getRecommendedPreventiveTests() {
		return recommendedPreventiveTests;
	}

	public void setRecommendedPreventiveTests(List<String> recommendedPreventiveTests) {
		this.recommendedPreventiveTests = recommendedPreventiveTests;
	}
	
	
	


	
}

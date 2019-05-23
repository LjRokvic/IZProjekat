package model;

import java.util.ArrayList;
import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class CaseDescription implements CaseComponent {
	
	
	private char gender;
	private int age;

	private List<String> symptoms = new ArrayList<String>();
	private List<String> tests = new ArrayList<String>();
	
	private String condition;

	@Override
	public Attribute getIdAttribute() {
		return null;
	}

	@Override
	public String toString() {
		return "CaseDescription [gender=" + gender + ", age=" + age + ", symptoms=" + symptoms + ", tests=" + tests
				+ ", condition=" + condition + "]";
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

	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	public List<String> getTests() {
		return tests;
	}

	public void setTests(List<String> tests) {
		this.tests = tests;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
}

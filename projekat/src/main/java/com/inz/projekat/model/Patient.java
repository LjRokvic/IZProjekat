package com.inz.projekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    private String name;

    private String lastName;
    
    private char gender;

   @ManyToMany(targetEntity = Condition.class, fetch = FetchType.EAGER)
    private List<Condition> conditions = new ArrayList<>();

    private int age;

    public Patient() {

    }

    public Patient(String name, String lastName, int age, char gender) {
        this.name = name;
        this.lastName = lastName;

        this.conditions = new ArrayList<>();
        this.age = age;
        this.gender = gender;
    }

    public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package com.inz.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    private String name;

    private String lastName;

    private boolean isMale;

   @OneToMany(targetEntity = Condition.class, fetch = FetchType.EAGER)
    private List<Condition> conditions;

    private int age;

    public Patient() {

    }

    public Patient(String name, String lastName, boolean isMale, int age) {
        this.name = name;
        this.lastName = lastName;
        this.isMale = isMale;
        this.conditions = new ArrayList<>();
        this.age = age;
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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
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

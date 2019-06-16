package com.inz.projekat.DTO;


import java.io.Serializable;
import java.util.List;

public class InfoDTO implements Serializable {

    private List<String> symptoms;

    private List<String> negativeSymptoms;

    public InfoDTO() {

    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public List<String> getNegativeSymptoms() {
        return negativeSymptoms;
    }

    public void setNegativeSymptoms(List<String> negativeSymptoms) {
        this.negativeSymptoms = negativeSymptoms;
    }
}

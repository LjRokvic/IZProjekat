package com.inz.projekat.DTO;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class DataDTO {


    private List<String> conditions = new ArrayList<>();


    private List<String> symptoms = new ArrayList<>();

    public DataDTO() {
    }

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }
}

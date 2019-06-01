package com.inz.projekat.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseDTO implements Serializable {

    private String condition;

    private int type; // 0 only Num, 1 only Prob, 2 Num and Prob

    private double prob;

    private int num;

    private List<String> decision = new ArrayList<>();

    public ResponseDTO() {
    }

    public ResponseDTO(String condition, int type, double prob, int num, List<String> decision) {
        this.condition = condition;
        this.type = type;
        this.prob = prob;
        this.num = num;
        this.decision = decision;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<String> getDecision() {
        return decision;
    }

    public void setDecision(List<String> decision) {
        this.decision = decision;
    }
}

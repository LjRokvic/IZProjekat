package com.inz.projekat.DTO;

import java.util.Objects;

public class BayesDTO {

    private String name;
    private double prob;

    public BayesDTO() {
    }

    public BayesDTO(String name, double prob) {
        this.name = name;
        this.prob = prob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BayesDTO bayesDTO = (BayesDTO) o;
        return Objects.equals(name, bayesDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

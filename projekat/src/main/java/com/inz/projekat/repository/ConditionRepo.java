package com.inz.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inz.projekat.model.Condition;

public interface ConditionRepo extends JpaRepository<Condition, Long> {

    public Condition findFirstById(Long id);

    public Condition findByName(String name);
}

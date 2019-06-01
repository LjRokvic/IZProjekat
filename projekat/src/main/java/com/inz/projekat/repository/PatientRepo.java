package com.inz.projekat.repository;

import com.inz.projekat.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

    public Patient findFirstById(Long id);
}

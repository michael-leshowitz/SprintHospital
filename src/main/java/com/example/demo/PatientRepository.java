package com.example.demo;

import models.Patient;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan("models")
public interface PatientRepository extends CrudRepository<Patient, Integer> {
}

//ToDo
//Create repositories for all other models
//ToDo
//Look into a generic repository. Would be easier than 12 interfaces.
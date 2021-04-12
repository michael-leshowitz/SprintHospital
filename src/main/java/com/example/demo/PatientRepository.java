package com.example.demo;

import models.Patient;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EntityScan("models")
public interface PatientRepository extends JpaRepository<Patient, Integer> {

   @Query(value = "SELECT * FROM patient WHERE firstName= ?1", nativeQuery = true)
    List<Patient> findByFirstName(String firstname);

    @Query(value = "SELECT * FROM patient WHERE user_name= ?1", nativeQuery = true)
    List<Patient> findByUserName(String userName);
}
//@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//User findUserByStatusAndName(Integer status, String name);

//ToDo
//Create repositories for all other models
//ToDo
//Look into a generic repository. Would be easier than 12 interfaces.
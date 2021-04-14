package com.example.demo;

import Repositories.PatientRepository;
import models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientDetailService implements UserDetailsService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByUserName(user_name);
        if(patient == null)
            throw new UsernameNotFoundException("No patient found with this username.");

        return new PatientPrincipal(patient);
    }
}

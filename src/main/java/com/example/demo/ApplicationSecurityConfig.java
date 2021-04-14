package com.example.demo;

import Services.PatientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("Services")
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PatientDetailService patientDetailService;

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(patientDetailService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        //TODO Replace setPasswordEncoder with some encryption
        return provider;
    }

}

package com.academic.erp_backend.configuration;

import com.academic.erp_backend.exception.EmployeeNotFoundException;
import com.academic.erp_backend.repo.EmployeeRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AuthenticationConfiguration {

    private final EmployeeRepo employeeRepo;

    public AuthenticationConfiguration(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return username -> (UserDetails) employeeRepo.findByEmail(username)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee With Email: " + username + " Not Found"));
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}
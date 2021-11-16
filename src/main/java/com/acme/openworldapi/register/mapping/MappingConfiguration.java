package com.acme.openworldapi.register.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("registerMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public PatientMapper patientMapper(){
        return new PatientMapper();
    }
}

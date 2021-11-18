package com.acme.openworldapi.appointment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reservingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public DoctorMapper doctorMapper(){
        return new DoctorMapper();
    }

    @Bean
    public ReservationMapper reservationMapper(){
        return new ReservationMapper();
    }

    @Bean
    public PatientMapper patientMapper(){
        return new PatientMapper();
    }
}

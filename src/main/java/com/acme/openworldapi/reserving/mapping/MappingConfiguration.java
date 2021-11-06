package com.acme.openworldapi.reserving.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reservingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public DoctorMapper doctorMapper(){
        return new DoctorMapper();
    }

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    /**
    @Bean
    public ReservationMapper commentMapper(){
        return new ReservationMapper();
    }**/
}

package com.acme.openworldapi.appointment.resource;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorResource {
    private Long id;
    private String name;
    private int age;
    private String photoUrl;
    private String description;
    private String workplace;
    private String specialty;
    private int qualification;
}
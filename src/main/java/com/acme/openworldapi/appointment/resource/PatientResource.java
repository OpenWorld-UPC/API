package com.acme.openworldapi.appointment.resource;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientResource {
    private Long id;
    private String name;
    private int age;
    private String photoUrl;
}

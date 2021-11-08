package com.acme.openworldapi.register.resource;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientResource {
    private Long id;
    private String name;
    private int age;
    private String photoUrl;
    private String consultation;
}

package com.acme.openworldapi.appointment.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreatePatientResource {

    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    private int age;


    @NotBlank
    @Size(max = 1000)
    private String photoUrl;
}

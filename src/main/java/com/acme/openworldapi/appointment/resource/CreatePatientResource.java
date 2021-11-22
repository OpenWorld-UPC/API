package com.acme.openworldapi.appointment.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
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

package com.acme.openworldapi.appointment.resource;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@With
public class PatientResource {
    private Long id;
    private String name;
    private int age;
    private String photoUrl;

}

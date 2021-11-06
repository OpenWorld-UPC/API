package com.acme.openworldapi.reserving.resource;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResource {
    private Long id;
    private String name;
    private int age;
    private String photoUrl;
}

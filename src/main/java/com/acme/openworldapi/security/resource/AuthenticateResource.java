package com.acme.openworldapi.security.resource;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class AuthenticateResource {

    private Long id;

    private String username;

    private String email;

    private List<String> role;

    private String token;
}

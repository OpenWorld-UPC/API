package com.acme.openworldapi.security.domain.service.communication;

import com.acme.openworldapi.security.resource.AuthenticateResource;
import com.acme.openworldapi.shared.domain.service.comunication.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {

    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}

package com.acme.openworldapi.security.domain.service.communication;

import com.acme.openworldapi.security.resource.UserResource;
import com.acme.openworldapi.shared.domain.service.comunication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {

    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}

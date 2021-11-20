package com.acme.openworldapi.security.domain.service;

import com.acme.openworldapi.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {
    void seed();

    List<Role> getAll();
}

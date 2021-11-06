package com.acme.openworldapi.reserving.domain.service;

import com.acme.openworldapi.reserving.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Page<User> getAll(Pageable pageable);
    User create(User user);
}

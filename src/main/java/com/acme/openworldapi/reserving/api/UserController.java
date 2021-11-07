package com.acme.openworldapi.reserving.api;

import com.acme.openworldapi.reserving.domain.model.entity.User;
import com.acme.openworldapi.reserving.domain.service.UserService;
import com.acme.openworldapi.reserving.mapping.UserMapper;
import com.acme.openworldapi.reserving.resource.CreateUserResource;
import com.acme.openworldapi.reserving.resource.UserResource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.mapper = userMapper;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public UserResource createDoctor(@Valid @RequestBody CreateUserResource resource) {
        return mapper.toResource(userService.create(mapper.toModel(resource)));
    }
}

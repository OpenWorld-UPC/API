package com.acme.openworldapi.security.service;

import com.acme.openworldapi.security.domain.model.entity.User;
import com.acme.openworldapi.security.domain.persistence.RoleRepository;
import com.acme.openworldapi.security.domain.persistence.UserRepository;
import com.acme.openworldapi.security.domain.service.UserService;
import com.acme.openworldapi.security.domain.service.communication.AuthenticateRequest;
import com.acme.openworldapi.security.domain.service.communication.RegisterRequest;
import com.acme.openworldapi.security.middleware.JwtHandler;
import com.acme.openworldapi.security.middleware.UserDetailsImpl;
import com.acme.openworldapi.shared.mapping.EnhancedModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtHandler handler;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    EnhancedModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with username : %s", username)));
        return UserDetailsImpl.build(user);
    }

    @Override
    public ResponseEntity<?> authenticate(AuthenticateRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(RegisterRequest request) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }


}

package com.acme.openworldapi.reserving.mapping;

import com.acme.openworldapi.reserving.domain.model.entity.Doctor;
import com.acme.openworldapi.reserving.resource.CreateDoctorResource;
import com.acme.openworldapi.reserving.resource.DoctorResource;
import com.acme.openworldapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping

    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }

    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

    public User toModel(CreateUserResource resource) {
        return mapper.map(resource, User.class);
    }

}

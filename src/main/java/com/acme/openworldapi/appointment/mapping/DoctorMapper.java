package com.acme.openworldapi.appointment.mapping;

import com.acme.openworldapi.appointment.domain.model.entity.Doctor;
import com.acme.openworldapi.appointment.resource.CreateDoctorResource;
import com.acme.openworldapi.appointment.resource.DoctorResource;
import com.acme.openworldapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class DoctorMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping

    public DoctorResource toResource(Doctor model){
        return mapper.map(model, DoctorResource.class);
    }

    public Page<DoctorResource> modelListToPage(List<Doctor> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, DoctorResource.class), pageable, modelList.size());
    }

    public Doctor toModel(CreateDoctorResource resource) {
        return mapper.map(resource, Doctor.class);
    }

    /**
    public Doctor toModel(UpdatePostResource resource){
        return mapper.map(resource, Post.class);
    }
    **/

}

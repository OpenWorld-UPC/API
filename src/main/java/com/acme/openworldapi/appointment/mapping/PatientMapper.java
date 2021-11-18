package com.acme.openworldapi.appointment.mapping;

import com.acme.openworldapi.appointment.domain.model.entity.Patient;
import com.acme.openworldapi.appointment.resource.CreatePatientResource;
import com.acme.openworldapi.appointment.resource.PatientResource;
import com.acme.openworldapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PatientMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping

    public PatientResource toResource(Patient model){
        return mapper.map(model, PatientResource.class);
    }

    public Page<PatientResource> modelListToPage(List<Patient> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, PatientResource.class), pageable, modelList.size());
    }

    public Patient toModel(CreatePatientResource resource) {
        return mapper.map(resource, Patient.class);
    }
}

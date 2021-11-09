package com.acme.openworldapi.register.domain.service;

import com.acme.openworldapi.register.domain.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Page<Patient> getAll(Pageable pageable);
    Patient create(Patient patient);
    Patient getById(Long patientId);
}

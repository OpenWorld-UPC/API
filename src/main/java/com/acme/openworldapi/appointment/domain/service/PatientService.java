package com.acme.openworldapi.appointment.domain.service;

import com.acme.openworldapi.appointment.domain.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Page<Patient> getAll(Pageable pageable);
    Patient create(Patient patient);
    Patient getById(Long patientId);
}

package com.acme.openworldapi.reserving.domain.service;

import com.acme.openworldapi.reserving.domain.model.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAll();
    Page<Doctor> getAll(Pageable pageable);
    Doctor create(Doctor doctor);
}

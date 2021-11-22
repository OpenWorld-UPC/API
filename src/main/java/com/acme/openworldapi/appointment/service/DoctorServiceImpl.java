package com.acme.openworldapi.appointment.service;

import com.acme.openworldapi.appointment.domain.model.entity.Doctor;
import com.acme.openworldapi.appointment.domain.persistence.DoctorRepository;
import com.acme.openworldapi.appointment.domain.service.DoctorService;
import com.acme.openworldapi.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static final String ENTITY = "Doctor";

    private final DoctorRepository doctorRepository;

    private final Validator validator;

    public DoctorServiceImpl(DoctorRepository doctorRepository, Validator validator) {
        this.doctorRepository = doctorRepository;
        this.validator = validator;
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Page<Doctor> getAll(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    @Override
    public Doctor create(Doctor doctor) {
        Set<ConstraintViolation<Doctor>> violations = validator.validate(doctor);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return doctorRepository.save(doctor);
    }
}

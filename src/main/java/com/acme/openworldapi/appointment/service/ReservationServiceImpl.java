package com.acme.openworldapi.appointment.service;

import com.acme.openworldapi.appointment.domain.model.entity.Doctor;
import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import com.acme.openworldapi.appointment.domain.persistence.DoctorRepository;
import com.acme.openworldapi.appointment.domain.persistence.PatientRepository;
import com.acme.openworldapi.appointment.domain.persistence.ReservationRepository;
import com.acme.openworldapi.appointment.domain.service.ReservationService;
import com.acme.openworldapi.shared.exception.ResourceNotFoundException;
import com.acme.openworldapi.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final String ENTITY = "Reservation";

    private final ReservationRepository reservationRepository;

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    private final Validator validator;

    public ReservationServiceImpl(ReservationRepository reservationRepository, DoctorRepository doctorRepository, PatientRepository patientRepository, Validator validator) {
        this.reservationRepository = reservationRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.validator = validator;
    }

    @Override
    public List<Reservation> getAllByDoctorIdPatientId(Long doctorId, Long patientId) {
        return reservationRepository.findByDoctorId(doctorId);
    }


    @Override
    public Reservation create(Long doctorId, Long patientId, Reservation request) {

        Set<ConstraintViolation<Reservation>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        doctorRepository.findById(doctorId).map(doctor ->
                patientRepository.findById(patientId).map(patient ->
                        reservationRepository.save(request.withDoctor(doctor).withPatient(patient))
                )).orElseThrow(() -> new ResourceNotFoundException("Doctor", doctorId));
        ;
        return request;
    }

    @Override
    public Reservation update(Long doctorId, Long ReservationId, Reservation request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long doctorId, Long ReservationId) {
        return null;
    }

    @Override
    public List<Reservation> getAllByPatientId(Long patientId) {
        return reservationRepository.findByPatientId(patientId);
    }

    @Override
    public Page<Reservation> getAllByPatientId(Long patientId, Pageable pageable) {
        return reservationRepository.findByPatientId(patientId, pageable);
    }
}
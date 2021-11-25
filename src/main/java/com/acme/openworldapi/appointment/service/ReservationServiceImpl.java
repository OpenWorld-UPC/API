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
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Reservation getAllReservations(Long reservationId) {
        return reservationRepository.findById(reservationId).orElseThrow(()-> new ResourceNotFoundException("Reservation", reservationId));
    }
}
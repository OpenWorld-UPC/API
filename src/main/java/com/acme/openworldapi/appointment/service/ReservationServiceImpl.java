package com.acme.openworldapi.appointment.service;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import com.acme.openworldapi.appointment.domain.persistence.DoctorRepository;
import com.acme.openworldapi.appointment.domain.persistence.PatientRepository;
import com.acme.openworldapi.appointment.domain.persistence.ReservationRepository;
import com.acme.openworldapi.appointment.domain.service.ReservationService;
import com.acme.openworldapi.shared.exception.ResourceNotFoundException;
import com.acme.openworldapi.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
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
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getAllReservationsById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }
}
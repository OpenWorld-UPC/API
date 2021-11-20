package com.acme.openworldapi.appointment.service;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import com.acme.openworldapi.appointment.domain.persistence.DoctorRepository;
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
import java.util.List;
import java.util.Set;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final String ENTITY = "Reservation";

    private final ReservationRepository reservationRepository;

    private final DoctorRepository doctorRepository;

    private final Validator validator;

    public ReservationServiceImpl(ReservationRepository reservationRepository, DoctorRepository doctorRepository, Validator validator) {
        this.reservationRepository = reservationRepository;
        this.doctorRepository = doctorRepository;
        this.validator = validator;
    }

    @Override
    public List<Reservation> getAllByDoctorId(Long doctorId) {
        return reservationRepository.findByDoctorId(doctorId);
    }

    @Override
    public Page<Reservation> getAllByDoctorId(Long doctorId, Pageable pageable) {
        return reservationRepository.findByDoctorId(doctorId, pageable);
    }

     @Override
    public Reservation create(Long doctorId, Reservation request) {

        Set<ConstraintViolation<Reservation>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return doctorRepository.findById(doctorId).map(doctor ->
                reservationRepository.save(request.withDoctor(doctor))).orElseThrow(() -> new ResourceNotFoundException("Doctor", doctorId));

    }

    @Override
    public Reservation update(Long doctorId, Long ReservationId, Reservation request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long doctorId, Long ReservationId) {
        return null;
    }
}

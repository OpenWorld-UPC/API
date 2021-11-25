package com.acme.openworldapi.appointment.service;

import com.acme.openworldapi.appointment.domain.model.entity.Doctor;
import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import com.acme.openworldapi.appointment.domain.persistence.DoctorRepository;
import com.acme.openworldapi.appointment.domain.persistence.PatientRepository;
import com.acme.openworldapi.appointment.domain.persistence.ReservationRepository;
import com.acme.openworldapi.appointment.domain.service.ReservationService;
import com.acme.openworldapi.appointment.resource.ReservationResource;
import com.acme.openworldapi.shared.exception.ResourceNotFoundException;
import com.acme.openworldapi.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Reservation createByDoctorIdAndPatientId(Long doctorId, Long patientId, Reservation request) {

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

    @Transactional(readOnly = true)
    @Override
    public List<Reservation> getAllReservationsByPatientId(Long patientId) {
        return reservationRepository.findByPatientId(patientId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reservation> getAllReservationsByDoctorIdAndPatientId(Long doctorId, Long patientId) {
        return reservationRepository.findAllReservationsByDoctorIdAndPatientId(doctorId, patientId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Reservation> getReservationByDoctorIdAndPatientIdAndReservationId(Long doctorId, Long patientId, Long reservationId){
        return reservationRepository.findReservationByDoctorIdAndPatientIdAndReservationId(doctorId, patientId, reservationId);
    }

    @Override
    public Reservation create(Reservation reservation) {
        Set<ConstraintViolation<Reservation>> violations = validator.validate(reservation);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return reservationRepository.save(reservation);
    }
}
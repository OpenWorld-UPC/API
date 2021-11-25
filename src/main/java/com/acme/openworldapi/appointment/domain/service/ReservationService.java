package com.acme.openworldapi.appointment.domain.service;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    //Doctor Reservation
    List<Reservation> getAllByDoctorIdPatientId(Long doctorId, Long patientId);
    Page<Reservation> getAllByDoctorIdPatientId(Long doctorId, Long patientId, Pageable pageable);
    Reservation create(Long doctorId, Long patientId, Reservation request);
    Reservation update(Long doctorId, Long ReservationId, Reservation request);
    ResponseEntity<?> delete(Long doctorId, Long ReservationId);

    //Patient Reservation
    List<Reservation> getAllByPatientId(Long patientId);
    Page<Reservation> getAllByPatientId(Long patientId, Pageable pageable);
}
package com.acme.openworldapi.appointment.domain.service;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllByDoctorId(Long doctorId);
    Page<Reservation> getAllByDoctorId(Long doctorId, Pageable pageable);
    Reservation create(Long doctorId, Reservation request);
    Reservation update(Long doctorId, Long ReservationId, Reservation request);
    ResponseEntity<?> delete(Long doctorId, Long ReservationId);
}

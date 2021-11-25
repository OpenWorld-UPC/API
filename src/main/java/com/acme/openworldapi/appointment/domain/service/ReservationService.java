package com.acme.openworldapi.appointment.domain.service;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    Reservation create(Long doctorId, Long patientId, Reservation request);

    Reservation getAllReservations(Long reservationId);
}
package com.acme.openworldapi.appointment.domain.service;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation create(Long doctorId, Long patientId, Reservation request);

    List<Reservation> getAllReservations();

    Optional<Reservation> getReservationById(Long reservationId);

    List<Reservation> getReservationByDoctorId(Long doctorId);
}
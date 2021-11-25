package com.acme.openworldapi.appointment.domain.service;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import com.acme.openworldapi.appointment.resource.ReservationResource;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation createByDoctorIdAndPatientId(Long doctorId, Long patientId, Reservation request);

    List<Reservation> getAllReservations();

    List<Reservation> getAllReservationsByPatientId(Long patientId);

    List<Reservation> getAllReservationsByDoctorIdAndPatientId(Long doctorId, Long patientId);

    List<Reservation> getReservationByDoctorIdAndPatientIdAndReservationId(Long doctorId, Long patientId, Long ReservationId);

    Reservation create(Reservation toModel);
}
package com.acme.openworldapi.appointment.domain.persistence;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByDoctorId(Long DoctorId);
    Page<Reservation> findByDoctorId(Long DoctorId, Pageable pageable);
    Optional<Reservation> findByIdAndDoctorId(Long id, Long ReservationId);

    List<Reservation> findByPatientId(Long ReservationId);
    Page<Reservation> findByPatientId(Long ReservationId, Pageable pageable);
    Optional<Reservation> findByIdAndPatientId(Long id, Long ReservationId);
}
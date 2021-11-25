package com.acme.openworldapi.appointment.domain.persistence;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT p FROM Reservation p WHERE LOWER(p.doctor.id) = LOWER(:doctorId)")
    Optional<Reservation> findAllReservationByDoctorId(@Param("doctorId") Long doctorId);
}
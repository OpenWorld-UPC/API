package com.acme.openworldapi.appointment.domain.persistence;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select l from Reservation l where l.patient.id = 1 and l.doctor.id = 1")
    List<Reservation> findByDoctorIdAndPatientId(Long doctorId, Long patientId);

    List<Reservation> findByPatientId(Long ReservationId);
    Page<Reservation> findByPatientId(Long ReservationId, Pageable pageable);

    List<Reservation> findByDoctorId(Long DoctorId);
    Page<Reservation> findByDoctorId(Long DoctorId, Pageable pageable);
}
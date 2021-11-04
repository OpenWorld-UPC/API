package com.acme.openworldapi.reserving.domain.persistence;

import com.acme.openworldapi.reserving.domain.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

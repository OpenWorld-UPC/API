package com.acme.openworldapi.reserving.domain.persistence;

import com.acme.openworldapi.reserving.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

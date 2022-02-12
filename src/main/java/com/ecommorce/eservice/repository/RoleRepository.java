package com.ecommorce.eservice.repository;

import com.ecommorce.eservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

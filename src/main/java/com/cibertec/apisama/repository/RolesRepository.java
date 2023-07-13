package com.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.apisama.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}

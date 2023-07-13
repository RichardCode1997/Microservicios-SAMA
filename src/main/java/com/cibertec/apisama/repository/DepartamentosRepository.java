package com.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.apisama.model.Departamentos;

public interface DepartamentosRepository extends JpaRepository<Departamentos, Integer> {
}

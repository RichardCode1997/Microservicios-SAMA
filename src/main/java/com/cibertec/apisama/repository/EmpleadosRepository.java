package com.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.apisama.model.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {
}

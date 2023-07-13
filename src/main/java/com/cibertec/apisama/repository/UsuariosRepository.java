package com.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.apisama.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
}

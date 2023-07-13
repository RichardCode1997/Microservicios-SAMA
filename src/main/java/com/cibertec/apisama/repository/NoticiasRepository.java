package com.cibertec.apisama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.apisama.model.Noticias;

public interface NoticiasRepository extends JpaRepository<Noticias, Integer> {
}

package com.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.apisama.model.Noticias;
import com.cibertec.apisama.repository.NoticiasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiasService {

    private final NoticiasRepository noticiasRepository;

    @Autowired
    public NoticiasService(NoticiasRepository noticiasRepository) {
        this.noticiasRepository = noticiasRepository;
    }

    public Noticias crearNoticia(Noticias noticias) {
        return noticiasRepository.save(noticias);
    }

    public List<Noticias> listarNoticia() {
        return noticiasRepository.findAll();
    }

    public Noticias obtenerNoticiaPorId(int id) {
        Optional<Noticias> rol = noticiasRepository.findById(id);
        if (rol.isPresent()) {
            return rol.get();
        } else {
            throw new IllegalArgumentException("No se encontró la Noticia especificada.");
        }
    }

    public Noticias actualizarNoticia(Noticias noticias) {
        validarExistenciaNoticia(noticias.getIdNoticia());
        return noticiasRepository.save(noticias);
    }

    public void eliminarNoticia(int id) {
        validarExistenciaNoticia(id);
        noticiasRepository.deleteById(id);
    }

    private void validarExistenciaNoticia(int id) {
        if (!noticiasRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró la Noticia especificada.");
        }
    }
}

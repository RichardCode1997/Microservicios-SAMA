package com.cibertec.apisama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.apisama.model.Usuarios;
import com.cibertec.apisama.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Usuarios crearUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public List<Usuarios> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios obtenerUsuarioPorId(int id) {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new IllegalArgumentException("No se encontró el usuario especificado.");
        }
    }

    public Usuarios modificarUsuario(int id, Usuarios usuarioModificado) {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuarios usuarioExistente = usuarioOptional.get();
            // Actualizar los campos necesarios del usuario existente con los valores del usuario modificado
            usuarioExistente.setNombre(usuarioModificado.getNombre());
            usuarioExistente.setApellido(usuarioModificado.getApellido());
            usuarioExistente.setDni(usuarioModificado.getDni());
            usuarioExistente.setCorreo(usuarioModificado.getCorreo());
            usuarioExistente.setContraseña(usuarioModificado.getContraseña());
            usuarioExistente.setRol(usuarioModificado.getRol());
            return usuariosRepository.save(usuarioExistente);
        } else {
            throw new IllegalArgumentException("No se encontró el usuario especificado.");
        }
    }

    public void eliminarUsuario(int id) {
        Optional<Usuarios> usuarioOptional = usuariosRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuariosRepository.delete(usuarioOptional.get());
        } else {
            throw new IllegalArgumentException("No se encontró el usuario especificado.");
        }
    }
}

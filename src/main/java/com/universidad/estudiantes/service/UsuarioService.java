package com.universidad.estudiantes.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.estudiantes.model.Usuario;
import com.universidad.estudiantes.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository repo,
            @Lazy PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Transactional
    public void registrar(Usuario usuario) {
        if (repo.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
        }
        usuario.setContrasenia(encoder.encode(usuario.getContrasenia()));
        usuario.setRol("ROLE_USER");
        repo.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repo.findAll();
    }
}

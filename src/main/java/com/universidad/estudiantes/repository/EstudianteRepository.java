package com.universidad.estudiantes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidad.estudiantes.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByCarreraIgnoreCase(String carrera);

    List<Estudiante> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
}

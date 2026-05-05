package com.universidad.estudiantes.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del curso es obligatorio")
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "creditos")
    private int creditos;

    @ManyToMany
    @JoinTable(
        name = "curso_estudiante",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private Set<Estudiante> estudiantes = new HashSet<>();

    public void agregarEstudiante(Estudiante e) {
        this.estudiantes.add(e);
        e.getCursos().add(this);
    }

    public void quitarEstudiante(Estudiante e) {
        this.estudiantes.remove(e);
        e.getCursos().remove(this);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public Set<Estudiante> getEstudiantes() { return estudiantes; }
}
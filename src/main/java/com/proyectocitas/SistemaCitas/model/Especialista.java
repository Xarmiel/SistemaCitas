package com.proyectocitas.SistemaCitas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "especialistas")
@Data
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especialista_id")
    private Long especialistaId;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 100)
    private String especialidad;

    @Column(nullable = false, unique = true, length = 20)
    private String telefono;
}

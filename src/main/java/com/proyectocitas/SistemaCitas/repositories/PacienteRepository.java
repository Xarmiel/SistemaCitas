package com.proyectocitas.SistemaCitas.repositories;

import com.proyectocitas.SistemaCitas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existByDni(String dni);
    Paciente findByDni(String dni);
}

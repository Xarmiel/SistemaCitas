package com.proyectocitas.SistemaCitas.repositories;

import com.proyectocitas.SistemaCitas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}

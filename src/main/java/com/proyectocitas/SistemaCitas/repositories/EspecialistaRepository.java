package com.proyectocitas.SistemaCitas.repositories;

import com.proyectocitas.SistemaCitas.model.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialistaRepository extends JpaRepository<Especialista, Long> {
    boolean existsByTelefono(String telefono);
}

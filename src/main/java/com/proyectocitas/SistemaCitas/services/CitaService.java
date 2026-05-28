package com.proyectocitas.SistemaCitas.services;

import com.proyectocitas.SistemaCitas.model.Cita;

import java.util.List;

public interface CitaService {
    Cita agendarCita(Cita cita);
    List<Cita> listarCitas();
    List<Cita> listarCitasPorDni(String dni);
    Cita cambiarEstadoCita(long id, String nuevoEstado);

}

package com.proyectocitas.SistemaCitas.services;
import com.proyectocitas.SistemaCitas.model.Especialista;
import com.proyectocitas.SistemaCitas.model.Paciente;

import java.util.List;

public interface PacienteService {
    public Paciente registrarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
}

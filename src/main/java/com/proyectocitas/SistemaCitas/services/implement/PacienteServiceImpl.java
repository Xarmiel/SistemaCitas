package com.proyectocitas.SistemaCitas.services.implement;

import com.proyectocitas.SistemaCitas.model.Paciente;
import com.proyectocitas.SistemaCitas.repositories.PacienteRepository;
import com.proyectocitas.SistemaCitas.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        if (paciente.getDni() == null || !paciente.getDni().matches("^[0-9]{8}$")) {
            throw new IllegalArgumentException("El DNI debe tener exactamente 8 dígitos");
        }

        if (pacienteRepository.existsByDni(paciente.getDni())) {
            throw new IllegalArgumentException("El DNI existe en el sistema");
        }

        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPaciente (String dni) {
        Paciente paciente = pacienteRepository.findByDni(dni);
        if (paciente == null) {
            throw new IllegalArgumentException("El DNI no existe en el sistema");
        }
        return paciente;
    }
}

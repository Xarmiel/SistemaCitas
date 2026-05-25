package com.proyectocitas.SistemaCitas.services.implement;

import com.proyectocitas.SistemaCitas.model.Especialista;
import com.proyectocitas.SistemaCitas.repositories.EspecialistaRepository;
import com.proyectocitas.SistemaCitas.services.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EspecialistaServiceImpl implements EspecialistaService {
    @Autowired
    private EspecialistaRepository especialistaRepository;

    @Override
    public Especialista registrarEspecialista(Especialista especialista) {
        if (especialistaRepository.existsByTelefono(especialista.getTelefono())) {
            throw new IllegalArgumentException("El teléfono ya está registrado");
        }

        return especialistaRepository.save(especialista);
    }

    @Override
    public List<Especialista> listarEspecialistas() {
        return especialistaRepository.findAll();
    }
}

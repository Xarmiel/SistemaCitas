package com.proyectocitas.SistemaCitas.services;

import com.proyectocitas.SistemaCitas.model.Especialista;
import java.util.List;

public interface EspecialistaService {
    public Especialista registrarEspecialista(Especialista especialista);
    List<Especialista> listarEspecialistas();
}

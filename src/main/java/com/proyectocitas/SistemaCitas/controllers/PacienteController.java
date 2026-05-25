package com.proyectocitas.SistemaCitas.controllers;

import com.proyectocitas.SistemaCitas.model.Paciente;
import com.proyectocitas.SistemaCitas.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarPaciente(@RequestBody Paciente paciente){
        try {
            Paciente nuevoPaciente = pacienteService.registrarPaciente(paciente);
            return ResponseEntity.ok(nuevoPaciente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listarPacientes(){
        List<Paciente> lista = pacienteService.listarPacientes();
        return ResponseEntity.ok(lista);
    }
}

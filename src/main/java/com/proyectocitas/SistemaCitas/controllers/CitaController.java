package com.proyectocitas.SistemaCitas.controllers;

import com.proyectocitas.SistemaCitas.model.Cita;
import com.proyectocitas.SistemaCitas.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService CitaService;

    @PostMapping("/agendar")
    public ResponseEntity<?> agendarCita(@RequestBody Cita cita) {
        try {
            Cita nuevaCita = CitaService.agendarCita(cita);
            return ResponseEntity.ok().body(nuevaCita);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cita>> listarCitas(){
        List<Cita> lista = CitaService.listarCitas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/paciente/{dni}")
    public ResponseEntity<List<Cita>> listarCitasPorDni(@PathVariable String dni) {
        List<Cita> lista = CitaService.listarCitasPorDni(dni);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/cambiar-estado/{id}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id, @RequestParam String nuevoEstado){
        try {
            Cita citaActualizada = CitaService.cambiarEstadoCita(id, nuevoEstado);
            return ResponseEntity.ok(citaActualizada);
        } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

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
}

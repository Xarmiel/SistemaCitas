package com.proyectocitas.SistemaCitas.controllers;

import com.proyectocitas.SistemaCitas.model.Especialista;
import com.proyectocitas.SistemaCitas.services.EspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/especialistas")
public class EspecialistaController {
    @Autowired
    private EspecialistaService especialistaService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarEspecialista(@RequestBody Especialista especialista){
        try {
            Especialista nuevoEspecialista = especialistaService.registrarEspecialista(especialista);
            return ResponseEntity.ok(nuevoEspecialista);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Especialista>> listarEspecialistas(){
        List<Especialista> lista = especialistaService.listarEspecialistas();
        return ResponseEntity.ok(lista);
    }
}
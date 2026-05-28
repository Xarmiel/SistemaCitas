package com.proyectocitas.SistemaCitas.services.implement;

import com.proyectocitas.SistemaCitas.model.Cita;
import com.proyectocitas.SistemaCitas.repositories.CitaRepository;
import com.proyectocitas.SistemaCitas.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita agendarCita(Cita cita) {
        if (cita.getHoraFin().isBefore(cita.getHoraInicio())) {
            throw new IllegalArgumentException("La hora de fin no puede ser anterior a la de inicio");
        }

        if (LocalDate.now().isAfter(cita.getFecha())) {
            throw new IllegalArgumentException("La cita no puede ser agendada una fecha anterior a la actual");
        }

        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> listarCitas(){
        return citaRepository.findAll();
    }

    @Override
    public List<Cita> listarCitasPorDni(String dni){
        return citaRepository.findByPacienteDni(dni);
    }

    @Override
    public Cita cambiarEstadoCita (long id, String nuevoEstado) {
        if(!citaRepository.existsById(id)) {
            throw new IllegalArgumentException("la cita con ID " + id + " no existe");
        }
        Cita cita = citaRepository.findById(id);

        cita.setEstado(nuevoEstado);
        return citaRepository.save(cita);
    }

}

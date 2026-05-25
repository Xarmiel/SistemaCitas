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
}

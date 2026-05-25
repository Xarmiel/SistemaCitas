package com.proyectocitas.SistemaCitas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

//Base o sustento por el cual se trabaja con estas herramientas: Campero me rompe la cabeza con esto en clase, de algo tenía que servir que me haga volar con Spring Boot.

@Entity //Referencia que esta clase representa una tabla de la BD
@Table(name = "citas") //Nombre de la tabla en la BD
@Data //Herramienta Lombok: generador de getters, setters, etc. Auspiciador: Campero >:D
public class Cita {
    @Id //Indica que este dato es la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Hace que el ID aumente como el "Serial" de postgres
    private long citaId;

    @ManyToOne //Relación uno a muchos
    @JoinColumn(name = "paciente_id", nullable = false) //JoinColumn cuando se trata de llaves foráneas o que apuntan a otras clases
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "especialista_id", nullable = false)
    private Especialista especialista;

    @Column(nullable = false) //nullable significa que este dato es "not null" es decir, no puede estar vacío
    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false) //Se le agrega el "name = [NombreColumna]" cuando la variable es diferente al nombre
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false) //Se usa "name = [NombreColumna]" porque la variable se llama "horaFin" y la columna "hora_fin" son nombres diferentes
    private LocalTime horaFin;

    //En este caso no es necesario el "name = [NombreColumna]" porque la variable se llama "estado" y la columna también
    @Column(length = 20) //Length viene a ser el tamaño del parámetro que indica la BD, traducción: varchar(numero) = length = número
    private String estado = "pendiente";

    @Column(columnDefinition = "text") //esto en caso la variable sea un sencillo tipo "text"
    private String notas;

    //Esta columna solo registra la fecha actual en la que se creó el dato, no se puede cambiar ni insertar, es automático.
    @Column(name = "creado_en", updatable = false, insertable = false) //updatable = false (inmodificable), insertable = false (no se puede ingresar datos).
    private OffsetDateTime creadoEn;
}

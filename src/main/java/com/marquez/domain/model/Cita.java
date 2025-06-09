package com.marquez.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private LocalDate fecha;
    private String paciente;
    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;
    private String notas;
    private LocalTime hora;
}

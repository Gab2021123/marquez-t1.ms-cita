package com.marquez.web.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaRequestDTO {
    private LocalDate fecha;
    private String paciente;
    private Long doctorId;
    private String estado;
    private String notas;
    private LocalTime hora;
}

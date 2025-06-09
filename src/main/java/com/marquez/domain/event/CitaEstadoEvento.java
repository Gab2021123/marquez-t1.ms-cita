package com.marquez.domain.event;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CitaEstadoEvento {
    private Long id;
    private Long citaId;
    private String paciente;
    private String nuevoEstado;
}

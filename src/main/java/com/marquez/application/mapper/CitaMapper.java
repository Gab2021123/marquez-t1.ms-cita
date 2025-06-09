package com.marquez.application.mapper;

import com.marquez.domain.model.Cita;
import com.marquez.domain.model.EstadoCita;
import com.marquez.web.dto.CitaRequestDTO;
import com.marquez.web.dto.CitaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {

    public Cita toEntity(CitaRequestDTO citaRequestDTO){
        return  Cita.builder()
                .fecha(citaRequestDTO.getFecha())
                .paciente(citaRequestDTO.getPaciente())
                .doctorId(citaRequestDTO.getDoctorId())
                .estado(EstadoCita.valueOf(citaRequestDTO.getEstado()))
                .notas(citaRequestDTO.getNotas())
                .hora(citaRequestDTO.getHora())
                .build();
    }

    public CitaResponseDTO toDTO(Cita cita){
        return  CitaResponseDTO.builder()
                .id(cita.getId())
                .fecha(cita.getFecha())
                .paciente(cita.getPaciente())
                .doctorId(cita.getDoctorId())
                .estado(cita.getEstado().name())
                .notas(cita.getNotas())
                .hora(cita.getHora())
                .build();
    }
}

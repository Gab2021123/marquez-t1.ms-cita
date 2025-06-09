package com.marquez.application.service;

import com.marquez.web.dto.CambioEstadoRequestDTO;
import com.marquez.web.dto.CitaRequestDTO;
import com.marquez.web.dto.CitaResponseDTO;

import java.util.List;

public interface ICitaService {
    CitaResponseDTO solicitarCita(CitaRequestDTO citaRequestDTO);
    CitaResponseDTO actualizarEstado(CambioEstadoRequestDTO cambioEstadoRequestDTO);
    List<CitaResponseDTO> listarCitas();
}

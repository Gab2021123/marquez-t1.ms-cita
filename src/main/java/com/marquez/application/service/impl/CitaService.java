package com.marquez.application.service.impl;

import com.marquez.application.mapper.CitaMapper;
import com.marquez.application.service.ICitaService;
import com.marquez.config.KafkaProducerComponent;
import com.marquez.domain.event.CitaEstadoEvento;
import com.marquez.domain.model.Cita;
import com.marquez.domain.model.EstadoCita;
import com.marquez.domain.repository.CitaRepository;
import com.marquez.web.dto.CambioEstadoRequestDTO;
import com.marquez.web.dto.CitaRequestDTO;
import com.marquez.web.dto.CitaResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CitaService implements ICitaService {
    private final CitaRepository repository;
    private final CitaMapper citaMapper;
    private final KafkaProducerComponent kafkaProducer;
    @Override
    public CitaResponseDTO solicitarCita(CitaRequestDTO citaRequestDTO) {
        Cita cita = citaMapper.toEntity(citaRequestDTO);
        Cita citaGuardada =  repository.save(cita);
        log.info("Cita solicitada {}",citaGuardada.getId());
        return  citaMapper.toDTO(citaGuardada);
    }

    @Override
    public CitaResponseDTO actualizarEstado(CambioEstadoRequestDTO cambioEstadoRequestDTO) {
       Cita cita = repository
               .findById(cambioEstadoRequestDTO.getId())
               .orElseThrow(
                       ()-> new RuntimeException("Cita no encontrada")
               );
       cita.setEstado(EstadoCita.valueOf(cambioEstadoRequestDTO.getNuevoEstado()));
       Cita citaActualizada = repository.save(cita);
       CitaEstadoEvento event = CitaEstadoEvento
                .builder()
                .id(citaActualizada.getId())
                .paciente(citaActualizada.getPaciente())
                .nuevoEstado(citaActualizada.getEstado().name())
                .citaId(citaActualizada.getId())
                .build();
       kafkaProducer.enviarEventoCambioEstado(event);
        return citaMapper.toDTO(citaActualizada);
    }

    @Override
    public List<CitaResponseDTO> listarCitas() {
        return repository
                .findAll()
                .stream()
                .map(citaMapper::toDTO)
                .collect(Collectors.toList());
    }
}

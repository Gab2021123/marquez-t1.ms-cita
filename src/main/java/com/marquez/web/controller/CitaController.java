package com.marquez.web.controller;

import com.marquez.application.service.impl.CitaService;
import com.marquez.web.dto.CambioEstadoRequestDTO;
import com.marquez.web.dto.CitaRequestDTO;
import com.marquez.web.dto.CitaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {
    private  final CitaService citaService;

    @PostMapping("solicitarCita")
    public ResponseEntity<CitaResponseDTO> crear(@RequestBody CitaRequestDTO citaRequestDTO){
        return ResponseEntity.ok(citaService.solicitarCita(citaRequestDTO));
    }
//    @PatchMapping("/{id}/estado")
//    public ResponseEntity<CitaResponseDTO> actualizarEsatdo(@PathVariable Long id,@RequestParam String nuevoEstado){
//        return  ResponseEntity.ok(citaService.actualizarEstado(id,nuevoEstado));
//    }
      @PatchMapping("/actualizarEstado")
      public ResponseEntity<CitaResponseDTO> actualizarEsatdo(@RequestBody CambioEstadoRequestDTO cambioEstadoRequestDTO){
           return  ResponseEntity.ok(citaService.actualizarEstado(cambioEstadoRequestDTO));
      }
    @GetMapping("/listarCitas")
    public ResponseEntity<List<CitaResponseDTO>> listarCitas(){
        return  ResponseEntity.ok(citaService.listarCitas());
    }
}

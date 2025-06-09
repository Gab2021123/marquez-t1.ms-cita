package com.marquez.config;

import com.marquez.domain.event.CitaEstadoEvento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerComponent {
    private final KafkaTemplate<String,CitaEstadoEvento> kafkaTemplate;
    public void enviarEventoCambioEstado(CitaEstadoEvento evento){
        kafkaTemplate.send("topic-marquez",evento);
        log.info("El evento Kafka fue enviado {}",evento);
    }

}

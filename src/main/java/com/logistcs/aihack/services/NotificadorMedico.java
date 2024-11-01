package com.logistcs.aihack.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistcs.aihack.domain.entities.Medico;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificadorMedico {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar (Medico medico) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "notificar-request-exchange",
                "admin",
                objectMapper.writeValueAsString(medico)
        );
    }
}

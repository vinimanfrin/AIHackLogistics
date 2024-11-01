package com.logistcs.aihack.services.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificarResponseErroConsumidor {

    @RabbitListener(queues = {"notificar-response-erro-queue"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());
        System.out.println("Erro ao notificar o médico sobre sua nova conta: " + payload);
    }

}

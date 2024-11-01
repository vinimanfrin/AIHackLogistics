package com.logistcs.aihack.controllers;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class AssistantController {

    @Autowired
    private OpenAiChatClient openAiChatClient;

    @GetMapping
    public ResponseEntity<String> newChat(
                @RequestParam(value = "message",defaultValue = "Olá, boa tarde!") String message){
        return ResponseEntity.ok(openAiChatClient.call(message));
    }
}

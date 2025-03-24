package com.example.websocket_chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebsocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    public void handleMessage(Message message) {
        System.out.println(message.getUser() + " sent a message: " + message.getMessage());
        messagingTemplate.convertAndSend("/topic/messages", message);
        System.out.println("Message sent to /topic/messages: " + message.getUser() + ": " + message.getMessage());
    }
}

package com.example.websocket_chat;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketSessionManager {
    private final ArrayList<String> activeUsernames = new ArrayList<>();
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketSessionManager(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void addUser(String username) {
        activeUsernames.add(username);
    }

    public void removeUser(String username) {
        activeUsernames.remove(username);
    }

    public void broadcastActiveUsernames() {
        messagingTemplate.convertAndSend("topic/users/", activeUsernames);
        System.out.println("Broadcasting active usernames to /topic/users: " + activeUsernames);
    }

}

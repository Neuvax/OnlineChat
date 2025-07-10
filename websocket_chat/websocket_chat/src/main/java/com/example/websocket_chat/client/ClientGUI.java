package com.example.websocket_chat.client;

import java.util.concurrent.ExecutionException;

import com.example.websocket_chat.Message;

public class ClientGUI {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyStompClient myStompClient = new MyStompClient("User1");
        myStompClient.sendMessage(new Message("User1", "Hello, this is User1!"));
    }
}

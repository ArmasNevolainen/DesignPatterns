package org.example;

import java.util.*;

public class ChatClientImplementation implements ChatClient{
    private final Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public synchronized void sendMessage(String from, String to, String message) {
        ChatClientController recipient = clients.get(to);
        if (recipient != null) {
            recipient.receiveMessage(from, message);
        }
    }

    @Override
    public synchronized void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public synchronized String[] getClientUsernames() {
        return clients.keySet().toArray(new String[0]);
    }
}

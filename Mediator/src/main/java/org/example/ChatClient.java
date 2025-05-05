package org.example;

public interface ChatClient {
    void sendMessage(String from, String to, String message);
    void registerClient(ChatClientController client);
    String[] getClientUsernames();
}

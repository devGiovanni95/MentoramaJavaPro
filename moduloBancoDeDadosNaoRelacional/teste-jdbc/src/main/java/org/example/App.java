package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        MessageRepository messageRepository = new MessageRepository();
        messageRepository.insertMessage(new Message(1l, "Segunda mensagem"));
    }
}

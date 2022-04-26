package org.example;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        MessageRepository messageRepository = new MessageRepository();
//        messageRepository.insertMessage(new Message(1l, "Segunda mensagem"));
//        messageRepository.update(new Message(0L, "nulo"));
        messageRepository.delete(1L);
        List<Message> messages = messageRepository.findAll();
        messages.stream().forEach(System.out::println);
    }
}

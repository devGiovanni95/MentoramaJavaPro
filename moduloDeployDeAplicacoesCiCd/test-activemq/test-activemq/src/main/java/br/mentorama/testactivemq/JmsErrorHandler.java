package br.mentorama.testactivemq;

import org.springframework.util.ErrorHandler;

public class  JmsErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
        System.out.println("Error processing message "+ t.getMessage());
    }
}

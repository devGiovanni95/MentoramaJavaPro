package br.com.mentorama.alomundo.patterns;

import br.com.mentorama.alomundo.entities.Message;

public class Main {

    public static void main(String[] args) {
        Message message = new MessageBuilder()
                .whithId(1)
                .whithMessage("Teste")
                .whithDescricao("Descrição")
                .build();
        System.out.println(message);
    }
}

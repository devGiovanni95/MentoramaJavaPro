package br.com.mentorama.alomundo.patterns;

import br.com.mentorama.alomundo.entities.Message;
/*Padrao buider*/
public class MessageBuilder {

    private Integer id;
    private String message;
    private String autor;
    private String descricao;

    public MessageBuilder whithId(Integer id){
        this.id = id;
        return this;
    }

    public MessageBuilder whithMessage(String message){
        this.message = message;
        return this;
    }

    public MessageBuilder whithAutor(String autor){
        this.autor = autor;
        return this;
    }

    public MessageBuilder whithDescricao(String descricao){
        this.descricao = descricao;
        return this;
    }
    public Message build(){
        return new Message(id, message, autor, descricao);
    }

}


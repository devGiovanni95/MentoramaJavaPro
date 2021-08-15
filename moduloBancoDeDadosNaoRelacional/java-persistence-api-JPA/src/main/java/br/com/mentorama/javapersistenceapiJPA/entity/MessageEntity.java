package br.com.mentorama.javapersistenceapiJPA.entity;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id/*o id chave primaria da tabela*/
    @GeneratedValue/*Passando pra jpa a funcao de criar um novo id por sua implementação (o hibernate ira criar essa implementação parta criação dos id's)*/
    private Long id;

    @Column(name = "message", nullable = false)/*Coluna com o nome de mensagens e que nao pode ser nula*/
    private String message;


    public MessageEntity(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

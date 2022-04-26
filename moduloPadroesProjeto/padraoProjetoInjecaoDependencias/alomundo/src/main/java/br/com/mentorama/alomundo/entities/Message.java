package br.com.mentorama.alomundo.entities;

public class Message {

    private Integer id;
    private String message;
    private String autor;
    private String descricao;

    public Message() {
    }

    public Message(final Integer id, final String message) {
        this.id = id;
        this.message = message;
    }

    public Message(final Integer id, final String message, final String autor, final String descricao) {
        this.id = id;
        this.message = message;
        this.autor = autor;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", autor='" + autor + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

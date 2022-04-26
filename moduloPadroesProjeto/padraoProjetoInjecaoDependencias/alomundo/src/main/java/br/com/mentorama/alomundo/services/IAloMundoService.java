package br.com.mentorama.alomundo.services;

import br.com.mentorama.alomundo.entities.Message;

import java.util.List;

public interface IAloMundoService {

    List<Message> findAll(String message);

    Message findById(Integer id);

    Integer add(final Message message);

    void update(final Message message);

    void delete(Integer id);
}

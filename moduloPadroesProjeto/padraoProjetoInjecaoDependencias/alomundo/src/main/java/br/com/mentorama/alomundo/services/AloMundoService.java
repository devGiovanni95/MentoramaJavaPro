package br.com.mentorama.alomundo.services;

import br.com.mentorama.alomundo.entities.Message;
import br.com.mentorama.alomundo.processors.Processor;
import br.com.mentorama.alomundo.repositories.AloMundoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*Utilizamos a annotation service na classe que queremos que seje criado uma instancia para ser injetada e no
* annotation autowired no atributo que queremos injetar*/

/*nas versoes mais novas do spring em vez de colocarmos a annotation autowired no atributo
 *  podemos declarar ele no construtor assim  o proprio spring ja entende que é uma injecao de dependencia */

@Service
public class AloMundoService
        implements IAloMundoService {


    private AloMundoRepository aloMundoRepository = AloMundoRepository.getInstance();

    @Autowired
    private List<Processor> processors;

    public List<Message> findAll(String message) {
        if (message != null) {
            return aloMundoRepository.findAll(message);
        }
        return aloMundoRepository.findAll();
    }


    public Message findById(Integer id) {
        return aloMundoRepository.findById(id);
    }


    public Integer add(final Message message) {
        if (message.getId() == null) {
            message.setId(aloMundoRepository.count() + 1);
        }
        processors.stream().forEach(processor -> processor.process(message));

        aloMundoRepository.add(message);
        return message.getId();
    }


    public void update(final Message message) {

        aloMundoRepository.update(message);
    }


    public void delete(Integer id) {
        aloMundoRepository.delete(id);
    }
}

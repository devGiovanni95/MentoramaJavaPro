package br.com.mentorama.alomundo.controllers;

import br.com.mentorama.alomundo.entities.Message;
import br.com.mentorama.alomundo.services.IAloMundoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {

    private final List<Message> messages;

   /* @Autowired assim o spring injeta automaticamente a instancia para nos para que tenhamos tanto acoplamento no codigo
    e vai utilizar o padrao singleton automaticamente
    private AloMundoService aloMundoService;*/

    @Autowired
     private final IAloMundoService aloMundoService;

    /*Um outro jeito do programa fazer a indejao aumatica como é feito pelo spring teriamas que fazer do seguinte modo
     *
     *     private IAloMundoService aloMundoService = new AloMundoService();------mas iriamos causar um alto acoplamento que nao é o que queremos
     *
     *
     * */
    /*nas versoes mais novas do spring em vez de colocarmos a annotation autowired no atributo
     *  podemos declarar ele no construtor assim  o proprio spring ja entende que é uma injecao de dependencia */

    public OlaMundoController(IAloMundoService aloMundoService) {
        this.aloMundoService = aloMundoService;
        this.messages = new ArrayList<>();
    }

//    public OlaMundoController() {
//        this.messages = new ArrayList<>();
//    }


    @GetMapping
    public List<Message> findAll(@RequestParam(required = false) String message) {
        return aloMundoService.findAll(message);
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Integer id) {
        return aloMundoService.findById(id);
    }


    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Message message) {
        Integer id = aloMundoService.add(message);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Message message) {
        aloMundoService.update(message);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        aloMundoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    //conferir documentação
    //http://localhost:8080/v3/api-docs
    //conferir documentacao com interface grafica
    //http://localhost:8080/swagger-ui.html

}

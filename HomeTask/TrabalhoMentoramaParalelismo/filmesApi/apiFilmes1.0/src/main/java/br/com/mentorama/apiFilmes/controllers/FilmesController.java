package br.com.mentorama.apiFilmes.controllers;

import br.com.mentorama.apiFilmes.entities.Filmes;
import br.com.mentorama.apiFilmes.exceptions.UserNotFound;
import br.com.mentorama.apiFilmes.services.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/filmes")
@RestController
@Async
public class FilmesController {

    @Autowired
    private final FilmesService filmesService;

    public FilmesController(FilmesService filmesService){
        this.filmesService = filmesService;
    }


    @GetMapping
    public CompletableFuture<List<Filmes>> findAll(){
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.filmesService.findAll();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Filmes> findById(@PathVariable("id") Integer id){
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.filmesService.findById(id)
                .thenApply(x -> {
                    try {
                        return x.orElseThrow(UserNotFound::new);
                    } catch (UserNotFound e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    @PostMapping
    public CompletableFuture<Filmes> add(@RequestBody final Filmes filmes) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.filmesService.save(filmes);
    }

//    @PostMapping
//    public ResponseEntity<Filmes> add(@RequestBody final Filmes filmes) {
//          if (filmesList.contains(filmes.getId())){
//              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//          } else {  filmesService.add(filmes);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }}

//    @PutMapping
//    public ResponseEntity updateNome(@RequestBody final Filmes nome) {
//        filmesService.updateName(nome);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable("id") Integer id) {
//        filmesService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }


    //conferir documentação
    //http://localhost:8080/v3/api-docs
    //conferir documentacao com interface grafica
    //http://localhost:8080/swagger-ui.html
}


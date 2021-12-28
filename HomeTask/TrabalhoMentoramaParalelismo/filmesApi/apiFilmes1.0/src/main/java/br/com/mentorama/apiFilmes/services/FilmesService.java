package br.com.mentorama.apiFilmes.services;

import br.com.mentorama.apiFilmes.entities.Filmes;
import br.com.mentorama.apiFilmes.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class FilmesService{

    @Autowired
    private FilmesRepository filmesRepository;

    public FilmesService(FilmesRepository filmesRepository){
        this.filmesRepository = filmesRepository;
    }
//
//    public List<Filmes> findAll(Filmes filmes){
//        if (filmes != null){
//            return filmesRepository.findAll(filmes);
//        }
//        return filmesRepository.findAll();
//    }

    public CompletableFuture<List<Filmes>> findAll(){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return filmesRepository.findAllBy();
    }

    public CompletableFuture<Optional<Filmes>> findById(Integer id) {
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return this.filmesRepository.findOneById(id);
    }

    public CompletableFuture<Filmes> save(final Filmes filmes){
        System.out.println("ServiceThread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(filmesRepository.save(filmes));
    }

//    public void updateName(final Filmes nome){
//        filmesRepository.updateNome(nome);
//    }
//
//    public void updateDiretor(final Filmes diretor){
//        filmesRepository.updateDiretor(diretor);
//    }
//
//    public void updateAno(final Filmes ano){
//        filmesRepository.updateAno(ano);
//    }
//
//    public void updateNota(final Filmes nota){
//        filmesRepository.updateNota(nota);
//    }
//
//
//    public void delete(Integer id) {
//        filmesRepository.delete(id);
//    }

}

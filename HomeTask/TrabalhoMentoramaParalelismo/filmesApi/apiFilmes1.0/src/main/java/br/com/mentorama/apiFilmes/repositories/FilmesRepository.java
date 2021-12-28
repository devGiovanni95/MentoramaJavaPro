package br.com.mentorama.apiFilmes.repositories;

import br.com.mentorama.apiFilmes.entities.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Async("customThreadPool")
@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Integer> {


    CompletableFuture<Optional<Filmes>> findOneById(final Integer id);

    CompletableFuture<List<Filmes>> findAllBy();

//    private final List<Filmes> filmesList;
//
//    private FilmesRepository() {
//        this.filmesList = new ArrayList<>();
//    }
//
//    public CompletableFuture<List<Filmes>> findAll(){
//        return (CompletableFuture<List<Filmes>>) filmesList;
//    }
//
//    public List<Filmes> findAll(Filmes filmes){
//        return filmesList.stream()
//                .filter(filme -> filme.getNome().contains((CharSequence) filmes))
//                .collect(Collectors.toList());
//    }
//
//    public Filmes findId(Integer id){
//        return this.filmesList.stream()
//                .filter(filme -> filme.getId().equals(id))
//                .findFirst().orElse(null);
//    }
//
////    public void add( Filmes filmes){
////        if (filmesList.stream().filter(film -> film.getId().equals(filmes.getId())) && ) {
////        }
////
////        this.filmesList.add(filmes);
////    }
//
//    default CompletableFuture <Optional<Filmes>> addFilme(Filmes filmes){
//        if (filmesList.contains(filmes.getId())) {
//            System.out.println("Id ja existente");
//        }else if (filmesList.equals(filmes.getNome())  && filmesList.equals(filmes.getAno())  && filmesList.equals( filmes.getDiretor())){
//            System.out.println("Filme duplicado");
//        }else if (filmes.getNota() >= 1 && filmes.getNota() <= 5){
//            this.filmesList.add(filmes);
//        }
//        return filmes;
//    }
//
//    public void updateNome(final  Filmes filmes){
//        filmesList.stream().filter(filme -> filme.getId().equals(filmes.getId()))
//                .forEach(filme -> filme.setNome(filmes.getNome()));
//    }
//    public void updateDiretor(final  Filmes filmes){
//        filmesList.stream().filter(filme -> filme.getId().equals(filmes.getId()))
//                .forEach(filme -> filme.setDiretor(filmes.getDiretor()));
//    }
//    public void updateAno(final  Filmes filmes){
//        filmesList.stream().filter(filme -> filme.getId().equals(filmes.getId()))
//                .forEach(filme -> filme.setAno(filmes.getAno()));
//    }
//    public void updateNota(final  Filmes filmes){
//        filmesList.stream().filter(filme -> filme.getId().equals(filmes.getId()))
//                .forEach(filme -> filme.setNota(filmes.getNota()));
//    }
//
//    public void delete(@PathVariable("id") Integer id) {
//        filmesList.removeIf(filmes -> filmes.getId().equals(id));
//    }

//    public Filmes addFilme() {
//    }
//
//    public int cout(){
//        return filmesList.size();
//    }


}

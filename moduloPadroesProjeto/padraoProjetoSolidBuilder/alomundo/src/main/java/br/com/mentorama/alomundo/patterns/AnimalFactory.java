package br.com.mentorama.alomundo.patterns;

import br.com.mentorama.alomundo.entities.Animal;
import br.com.mentorama.alomundo.entities.Cachorro;
import br.com.mentorama.alomundo.entities.Gato;

/*Padrao factory method*/
public class AnimalFactory {

    public static Animal createAnimal(String nome, String especie){
        if (especie.equals("Gato")){
            return new Gato(nome, especie);
        }else if (especie.equals("Cachorro")){
            return new Cachorro(nome, especie);
        }
        throw new RuntimeException("Especie invalida de animal");
    }
}

package br.com.mentorama.alomundo.patterns;

import br.com.mentorama.alomundo.entities.Animal;

public class MainAnimalFactory {

    public static void main(String[] args) {
        System.out.println(Animal.padraoFactory("Gato", "Gato"));
        System.out.println(Animal.padraoFactory("Cachorro", "Cachorro"));
    }
}

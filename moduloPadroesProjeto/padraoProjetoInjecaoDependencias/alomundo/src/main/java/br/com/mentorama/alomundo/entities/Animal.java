package br.com.mentorama.alomundo.entities;
/*comeco factory method*/
public abstract class Animal {

    public String nome;
    public String especie;

    public Animal(final String nome, final String especie) {
        this.nome = nome;
        this.especie = especie;
    }

    /*Pode ser implementado aqui tambem */
    public static Animal padraoFactory(String nome, String especie){
        if (especie.equals("Gato")){
            return new Gato(nome, especie);
        }else if (especie.equals("Cachorro")){
            return new Cachorro(nome, especie);
        }
        throw new RuntimeException("Especie invalida de animal");
    }
}

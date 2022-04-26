package com.giovanni.trabalhocicd.model;

import java.io.Serializable;

public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String nome;

    private int nota;

    private String comentario;

    private int idUsuario;

    private String nomeUsuario;

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                ", idUsuario=" + idUsuario +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                '}';
    }
}

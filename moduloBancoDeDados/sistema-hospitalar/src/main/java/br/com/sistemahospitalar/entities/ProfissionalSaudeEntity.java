package br.com.sistemahospitalar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProfissionalSaudeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private  int matricula;

    @Column
    private String nome;

    @Column
    private String departamento;

    @Column
    private String cargo;

    @Column
    private String telefoneProfissional;

    public ProfissionalSaudeEntity(Long id, int matricula, String nome,
                                   String departamento, String cargo,
                                   String telefoneProfissional) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
        this.cargo = cargo;
        this.telefoneProfissional = telefoneProfissional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefoneProfissional() {
        return telefoneProfissional;
    }

    public void setTelefoneProfissional(String telefoneProfissional) {
        this.telefoneProfissional = telefoneProfissional;
    }
}

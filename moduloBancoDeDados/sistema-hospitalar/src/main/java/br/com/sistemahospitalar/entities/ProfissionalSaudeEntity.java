package br.com.sistemahospitalar.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProfissionalSaudeEntity {

    @Id
    @GeneratedValue
//    @OneToMany
    @ManyToMany(mappedBy = "medico")
    private Long id;

//    @Column(name = "matricula")
    private  int matricula;

//    @Column(name = "nome")
    private String nome;

//    @Column(name = "departamento")
    private String departamento;

//    @Column(name = "cargo")
    private String cargo;

//    @Column(name = "telefone")
    private String telefoneProfissional;

//    @OneToOne(mappedBy = "medico")
//    private List<ProfissionalSaudeEntity> profissionalSaudeEntities;

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

//    public List<ProfissionalSaudeEntity> getProfissionalSaudeEntities() {
//        return profissionalSaudeEntities;
//    }
//
//    public void setProfissionalSaudeEntities(List<ProfissionalSaudeEntity> profissionalSaudeEntities) {
//        this.profissionalSaudeEntities = profissionalSaudeEntities;
//    }

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

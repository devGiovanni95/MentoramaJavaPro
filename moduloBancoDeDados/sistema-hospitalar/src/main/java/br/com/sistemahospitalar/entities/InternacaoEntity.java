package br.com.sistemahospitalar.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InternacaoEntity {
//    @OneToOne
//   private int idPaciente;

//    @OneToOne
//    private ProfissionalSaudeEntity medico;


    @Id
    @GeneratedValue
    private Long internacaoPaciente;

//    @ManyToMany
//    @Column(name = "id_paciente")
//    private int idPaciente;

//    @Column(name = "nome_paciente ")
    private String nomePaciente;

//    @Column(name = "data_hora_entrada ")
    private String dataHoraEntrada;

//    @Column(name = "data_hora_saida ")
    private String dataHoraSaida;

//    @Column(name = "diagnostico")
    private String diagnostico;

//    @ManyToMany
//    @Column(name = "medico")
//    private int medico;

@ManyToMany
@JoinColumn(name = "medico")
    private List<ProfissionalSaudeEntity> medico = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name = "id_paciente")
    private List<PacienteEntity> id_paciente = new ArrayList<>();


    public InternacaoEntity(Long internacaoPaciente, List<PacienteEntity> id_paciente,
                            String nomePaciente, String dataHoraEntrada,
                            String dataHoraSaida, String diagnostico, List<ProfissionalSaudeEntity> medico) {

        this.internacaoPaciente = internacaoPaciente;
        this.id_paciente = id_paciente;
        this.nomePaciente = nomePaciente;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.diagnostico = diagnostico;
        this.medico = medico;
    }

    public List<ProfissionalSaudeEntity> getMedico() {
        return medico;
    }

    public void setMedico(List<ProfissionalSaudeEntity> medico) {
        this.medico = medico;
    }

    public List<PacienteEntity> getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(List<PacienteEntity> id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Long getInternacaoPaciente() {
        return internacaoPaciente;
    }

    public void setInternacaoPaciente(Long internacaoPaciente) {
        this.internacaoPaciente = internacaoPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(String dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public String getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(String dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }


}

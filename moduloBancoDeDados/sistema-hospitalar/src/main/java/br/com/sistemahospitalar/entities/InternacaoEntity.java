package br.com.sistemahospitalar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InternacaoEntity {

    @Id
    @GeneratedValue
    private Long internacaoPaciente;

    @Column
    private int idPaciente;

    @Column
    private String nomePaciente;

    @Column
    private String dataHoraEntrada;

    @Column
    private String dataHoraSaida;

    @Column
    private String diagnostico;

    public InternacaoEntity(Long internacaoPaciente, int idPaciente,
                            String nomePaciente, String dataHoraEntrada,
                            String dataHoraSaida, String diagnostico) {

        this.internacaoPaciente = internacaoPaciente;
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.diagnostico = diagnostico;
    }

    public Long getInternacaoPaciente() {
        return internacaoPaciente;
    }

    public void setInternacaoPaciente(Long internacaoPaciente) {
        this.internacaoPaciente = internacaoPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

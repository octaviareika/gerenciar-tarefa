package com.gerenciamento.tarefa.projeto;

import com.gerenciamento.tarefa.projeto.TarefaDTO.DadosAtualizarTarefa;
import com.gerenciamento.tarefa.projeto.TarefaDTO.TarefaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tarefa")
@Entity(name = "Tarefa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public String nome;
    public String descricao;

    @Enumerated(EnumType.STRING)
    public Status status;
    public String dataInicio;
    public String dataFim;


    public Tarefa(TarefaDTO tarefaDTO) {
        this.nome = tarefaDTO.nome();
        this.descricao = tarefaDTO.descricao();
        this.status = tarefaDTO.status();
        this.dataInicio = tarefaDTO.dataInicio();
        this.dataFim = tarefaDTO.dataFim();
    }

    public Tarefa(String nome, String descricao, Status status, String dataInicio, String dataFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getter e Setter
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    // toString
    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", status='" + getStatus() + "'" +
            ", dataInicio='" + getDataInicio() + "'" +
            ", dataFim='" + getDataFim() + "'" +
            "}";
    }

	public void atualizarDado(@Valid DadosAtualizarTarefa dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.dataFim() != null) {
            this.dataFim = dados.dataFim();
        }

	}
}

package com.gerenciamento.tarefa.projeto;

public record DadosAtualizadoTarefa(Long id, String nome, String descricao, Status status, String dataInicio, String dataFim) {

    public DadosAtualizadoTarefa(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getDataInicio(), tarefa.getDataFim());
    }
}

package com.gerenciamento.tarefa.projeto.TarefaDTO;

import com.gerenciamento.tarefa.projeto.Status;
import com.gerenciamento.tarefa.projeto.Tarefa;

public record DadosListagemTarefa(
            Long id,
            String nome,  
            Status status,  
            String dataFim) {

    public DadosListagemTarefa(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getNome(), tarefa.getStatus(), tarefa.getDataFim());
    }

    
    
}

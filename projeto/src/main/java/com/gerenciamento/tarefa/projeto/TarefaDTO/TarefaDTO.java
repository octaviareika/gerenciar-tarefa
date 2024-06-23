package com.gerenciamento.tarefa.projeto.TarefaDTO;

import com.gerenciamento.tarefa.projeto.Status;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record TarefaDTO(
            @NotBlank
            String nome, 

            @NotBlank
            String descricao, 

            @Valid
            Status status, 

            @NotBlank @Valid
            String dataInicio, 
            String dataFim) {
    
}

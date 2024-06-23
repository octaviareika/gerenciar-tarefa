package com.gerenciamento.tarefa.projeto.TarefaDTO;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTarefa(
        @NotNull
        Long id,
        
        String nome,
        String dataFim) {
    
}

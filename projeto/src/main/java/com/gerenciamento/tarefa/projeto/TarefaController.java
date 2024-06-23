package com.gerenciamento.tarefa.projeto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;
import com.gerenciamento.tarefa.projeto.Repository.RepositorioTarefa;
import com.gerenciamento.tarefa.projeto.TarefaDTO.DadosAtualizarTarefa;
import com.gerenciamento.tarefa.projeto.TarefaDTO.DadosListagemTarefa;
import com.gerenciamento.tarefa.projeto.TarefaDTO.TarefaDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    
    @Autowired
    private RepositorioTarefa repositorioTarefa;

    @PostMapping
    @Transactional
    public void cadastrarTarefa(@Valid @RequestBody TarefaDTO dados) {
        Tarefa tarefa = new Tarefa(dados);
        repositorioTarefa.save(tarefa);
        
    }

    @GetMapping
    public Page<DadosListagemTarefa> listarTarefas(@PageableDefault(size = 10, sort={"nome"}) Pageable pageable) {
        return repositorioTarefa.findAll(pageable)
        .map(t -> new DadosListagemTarefa(t.getId(), t.getNome(), t.getStatus(), t.getDataFim()));
    }

    @PutMapping // atualizar dados
    @Transactional
    public void atualizarTarefa(@Valid @RequestBody DadosAtualizarTarefa dados){
        var tarefa = repositorioTarefa.getReferenceById(dados.id());
        tarefa.atualizarDado(dados);
    }
}

package com.gerenciamento.tarefa.projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamento.tarefa.projeto.Tarefa;

@Repository
public interface RepositorioTarefa extends JpaRepository<Tarefa, Long>{


}

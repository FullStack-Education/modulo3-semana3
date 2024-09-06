package org.example.aula2.tarefas;

import lombok.RequiredArgsConstructor;
import org.example.aula2.controller.dto.TarefaRequest;
import org.example.aula2.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    final TarefaRepository repository;

    public Tarefa adicionarTarefa(TarefaRequest tarefa) {
        return repository.save(new Tarefa(tarefa.nome(), tarefa.descricao()));
    }

    public void removerTarefa(Long id) {
        repository.deleteById(id);
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa retornarTarefa( Long id ) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Item não encontrado!"));
    }

}

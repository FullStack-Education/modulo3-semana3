package org.example.aula2.tarefas;

import org.example.aula2.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    TarefaRepository repository;

    @InjectMocks
    TarefaService service;

    @Test
    void adicionarTarefa() {
        // given - dado
        Tarefa tarefa = new Tarefa(1L, "nome", "descricao");
        when(repository.save(any())).thenReturn(tarefa);

        // when - quando
        Tarefa retorno = service.adicionarTarefa(tarefa);

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefa.getNome(), retorno.getNome());

    }

    @Test
    void listarTarefas() {

        // given - dado
        Tarefa tarefa = new Tarefa(1L, "nome", "descricao");
        when(repository.findAll()).thenReturn(List.of(tarefa));

        // when - quando
        List<Tarefa> retorno = service.listarTarefas();

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefa.getNome(), retorno.get(0).getNome());
    }
}
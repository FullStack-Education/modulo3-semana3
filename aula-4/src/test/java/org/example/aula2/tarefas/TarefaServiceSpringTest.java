package org.example.aula2.tarefas;

import org.example.aula2.controller.dto.TarefaRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ActiveProfiles("test")
@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
class TarefaServiceSpringTest {

    @Autowired
    TarefaService service;

    static TarefaRequest tarefaRequest;

    @BeforeAll
    public static void setUp() {
        tarefaRequest = new TarefaRequest("nome", "descricao");
    }

    @Test
    void adicionarTarefa() {
        // when - quando
        Tarefa retorno = service.adicionarTarefa(tarefaRequest);

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefaRequest.nome(), retorno.getNome());


    }

    @Test
    void listarTarefas() {
        service.adicionarTarefa(tarefaRequest);

        // when - quando
        List<Tarefa> retorno = service.listarTarefas();

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefaRequest.nome(), retorno.get(0).getNome());
    }

    @Test
    void retornarTarefa() {
        service.adicionarTarefa(tarefaRequest);

        Tarefa retorno = service.retornarTarefa(1L);

        assertEquals(retorno.getNome(), tarefaRequest.nome());

    }
}
package org.example.aula2.tarefas;

import org.example.aula2.repository.TarefaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
class TarefaServiceSpringTest {

    @Autowired
    TarefaService service;

    static Tarefa tarefa;

    @BeforeAll
    public static void setUp() {
        tarefa = new Tarefa(1L, "nome", "descricao");
    }

    @Test
    void adicionarTarefa() {
        // when - quando
        Tarefa retorno = service.adicionarTarefa(tarefa);

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefa.getNome(), retorno.getNome());


    }

    @Test
    void listarTarefas() {
        service.adicionarTarefa(tarefa);

        // when - quando
        List<Tarefa> retorno = service.listarTarefas();

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefa.getNome(), retorno.get(0).getNome());
    }

    @Test
    void retornarTarefa() {
        service.adicionarTarefa(tarefa);

        Tarefa retorno = service.retornarTarefa(1L);

        assertEquals(retorno.getNome(), tarefa.getNome());

    }
}
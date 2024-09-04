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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class TarefaServiceSpringTest {

    @MockBean
    TarefaRepository repository;

    @Autowired
    TarefaService service;

    static Tarefa tarefa;

    @BeforeAll
    public static void setUp() {
        tarefa = new Tarefa(1L, "nome", "descricao");
    }

    @Test
    void adicionarTarefa() {
        // given - dado
        when(repository.save(any())).thenReturn(tarefa);

        // when - quando
        Tarefa retorno = service.adicionarTarefa(tarefa);

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefa.getNome(), retorno.getNome());

        verify(repository, times(1))
                .save(any()); // valida se o teste passou pela linha de código do repository com o metodo save

    }

    @Test
    void listarTarefas() {

        // given - dado
        when(repository.findAll()).thenReturn(List.of(tarefa));

        // when - quando
        List<Tarefa> retorno = service.listarTarefas();

        // then - então
        assertNotNull(retorno);
        assertEquals(tarefa.getNome(), retorno.get(0).getNome());
    }

    @Test
    void retornarTarefa() {

        // given - dado
        when(repository.findById(anyLong())).thenReturn(
                Optional.ofNullable(tarefa)
        );

        // valida se nenhum erro ocorreu
        assertDoesNotThrow(
                () -> service.retornarTarefa(1L)
        );
    }
}
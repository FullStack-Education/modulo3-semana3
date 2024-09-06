package org.example.aula2.tarefas;

import org.example.aula2.controller.dto.TarefaRequest;
import org.example.aula2.repository.TarefaRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TarefaServiceTest {

    @Mock
    TarefaRepository repository;

    //@Spy
    //TarefaMapper mapper;

    @InjectMocks
    TarefaService service;

    static Tarefa tarefa;

    @BeforeAll
    public static void setUp() {
        tarefa = new Tarefa(1L, "nome", "descricao");
    }

    @Test
    @Order(1)
    void adicionarTarefa() {
        // given - dado
        when(repository.save(any())).thenReturn(tarefa);

        // when - quando
        Tarefa retorno = service.adicionarTarefa(new TarefaRequest("nome","descricao"));

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
    @Order(2)
    void removerTarefaTest() {
        // when - quando
        assertDoesNotThrow(
                () -> service.removerTarefa(1L)
        );

    }

    @Test
    @Order(4)
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


    @Test
    void retornarTarefaError() {

        // valida se nenhum erro ocorreu
        assertThrows(
                RuntimeException.class,
                () -> service.retornarTarefa(0L)
        );
    }
}
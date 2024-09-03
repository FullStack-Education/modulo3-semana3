package tarefas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaTarefasTest {

    ListaTarefas listaTarefas;
    Tarefa tarefa;

    @BeforeEach
    public void setTarefa(){
        listaTarefas = new ListaTarefas();
        tarefa = new Tarefa("Teste", "Teste de Tarefas");
    }

    @Test
    void adicionarTarefa() {
        boolean resultado = listaTarefas.adicionarTarefa(tarefa);
        assertTrue(resultado);
    }

    @Test
    void removerTarefa() {
        listaTarefas.adicionarTarefa(tarefa);

        Tarefa resultado = listaTarefas.removerTarefa(0);

        assertEquals(tarefa.getNome(), resultado.getNome());
        assertEquals(tarefa.getDescricao(), resultado.getDescricao());
    }

    @Test
    void listarTarefas() {

        listaTarefas.adicionarTarefa(tarefa);

        List<Tarefa> resultado = listaTarefas.listarTarefas();

        assertEquals(tarefa.getNome(), resultado.get(0).getNome());
        assertEquals(tarefa.getDescricao(), resultado.get(0).getDescricao());
    }

    @Test
    void retornarTarefa() {
        listaTarefas.adicionarTarefa(tarefa);

        Tarefa resultado = listaTarefas.retornarTarefa(0);

        assertEquals(tarefa.getNome(), resultado.getNome());
        assertEquals(tarefa.getDescricao(), resultado.getDescricao());
    }
}
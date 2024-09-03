package tarefas;

import java.util.ArrayList;

public class ListaTarefas {

    private static ArrayList<Tarefa> tarefas = new ArrayList<>();

    public boolean adicionarTarefa(Tarefa tarefa) {
        return tarefas.add(tarefa);
    }

    public Tarefa removerTarefa(int id) {
        return tarefas.remove(id);
    }

    public ArrayList<Tarefa> listarTarefas() {
        return tarefas;
    }

    public Tarefa retornarTarefa( int id ) {
        return tarefas.get(id);
    }

}

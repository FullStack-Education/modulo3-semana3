package org.example.aula2.controller;

import lombok.RequiredArgsConstructor;
import org.example.aula2.tarefas.TarefaService;
import org.example.aula2.tarefas.Tarefa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> buscaTarefas(){
        List<Tarefa> retorno = tarefaService.listarTarefas();
        return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public ResponseEntity<Void> salvaTarefa(
            @RequestBody Tarefa tarefa
    ){
        tarefaService.adicionarTarefa(tarefa);
        return ResponseEntity.noContent().build();
    }


}

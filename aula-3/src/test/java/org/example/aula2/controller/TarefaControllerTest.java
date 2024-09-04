package org.example.aula2.controller;

import org.example.aula2.repository.TarefaRepository;
import org.example.aula2.tarefas.TarefaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
class TarefaControllerTest {

    @MockBean
    TarefaService service;

    @Autowired
    MockMvc mockMvc;


    @Test
    void buscaTarefas() throws Exception {
        //when(service.listarTarefas()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                get("/tarefas")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void salvaTarefa() {
    }
}
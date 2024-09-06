package org.example.aula2.controller;

import org.example.aula2.repository.TarefaRepository;
import org.example.aula2.tarefas.TarefaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TarefaControllerTest {

    @Autowired
    MockMvc mockMvc;
    

    @Test
    void buscaTarefas() throws Exception {
        mockMvc.perform(
                post("/tarefas")
                        .content("{\n" +
                                "\t\"nome\":\"nome\",\n" +
                                "\t\"descricao\": \"desc\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isNoContent());

        mockMvc.perform(
                get("/tarefas")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("nome"));
    }

    @Test
    void salvaTarefa() throws Exception {
        mockMvc.perform(
                post("/tarefas")
                        .content("{\n" +
                                "\t\"nome\":\"nome\",\n" +
                                "\t\"descricao\": \"desc\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andExpect(status().isNoContent())
                ;
    }

    @Test
    void salvaTarefaError() throws Exception {
        mockMvc.perform(
                post("/tarefas")
                        .content("{\n" +
                                "\t\"nome\":\"\",\n" +
                                "\t\"descricao\": \"\"\n" +
                                "}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isBadRequest())
        ;
    }
}
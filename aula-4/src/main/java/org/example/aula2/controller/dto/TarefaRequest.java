package org.example.aula2.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaRequest(
        @NotNull @NotBlank String nome,
        @NotNull @NotBlank String descricao
) {
}

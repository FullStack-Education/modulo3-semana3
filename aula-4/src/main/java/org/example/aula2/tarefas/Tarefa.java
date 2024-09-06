package org.example.aula2.tarefas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;


    public Tarefa(@NotNull @NotBlank String nome, @NotNull @NotBlank String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}

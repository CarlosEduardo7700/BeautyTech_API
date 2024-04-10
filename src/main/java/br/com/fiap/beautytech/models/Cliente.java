package br.com.fiap.beautytech.models;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import br.com.fiap.beautytech.models.enums.Genero;

import java.time.LocalDate;

public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private LocalDate dataDeNascimento;
    private EstadoCivil estadoCivil;
    private Genero genero;
    private LocalDate dataDeCadastro;
    private LocalDate dataDeExclusao;
}

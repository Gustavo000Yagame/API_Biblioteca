package com.example.biblioteca.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AutorResquestDTO(

        @Column(nullable = false, length = 50)
        @NotBlank(message = "O nome e obrigatorio!")
        String nome,

        @NotBlank(message = "A nacionalidade e obrigatoria!")
        String nacionalidade,

        @Column(unique = true, length = 10)
        @NotBlank(message = "O telefone e obrigatorio!" )
        String telefone,

        @Column(nullable = false)
        @Email(message = "O email deve conter @gmail e .comn")
        @NotBlank(message = "O email e obrigatorio!")
        String email


){}

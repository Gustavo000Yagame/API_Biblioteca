package com.example.biblioteca.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record LivroRequestDTO(

        @NotBlank(message = "O titulo e obrigatorio")
        String titulo,

        @NotBlank(message = "O codigo ISBN e obrigatorio para identificacao do livro")
        String isbn,

        @Min(value = 1800, message = "Digite algo do ano 1800 ou +")
        @Max(value = 2026, message = "Meu patrao se e do futuro? chama noisa ai pra ir junto mano brow")
        Integer anoPublicacao,

        Long    autorId

){}

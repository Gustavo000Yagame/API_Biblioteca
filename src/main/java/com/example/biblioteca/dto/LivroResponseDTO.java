package com.example.biblioteca.dto;

public record LivroResponseDTO (

        Long idLivro,

        String titulo,

        String isbn,

        Integer anoPublicacao,

        Long idAutor, //vou colocar mais se ficar  feio tiro

        String nomeAutor

){}

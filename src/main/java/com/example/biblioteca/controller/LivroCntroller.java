package com.example.biblioteca.controller;

import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.dto.LivroRequestDTO;
import com.example.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Controller do livro", description = "Rotas para gerencimento do livro")
@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroCntroller {

    private final LivroService livroService;

    @Operation(summary = "GET simples do para lisatar todos os livros")
    @GetMapping
    public List<LivroResponseDTO> listarTodosLivros(){
        return livroService.listarTodosLivros();
    }

    @Operation(summary = "POST para cadastrar Livros")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroResponseDTO cadastrarLivros(@Valid @RequestBody LivroRequestDTO dto){
    return livroService.cadastrarLivros(dto);
    }

    @Operation(summary = "GET{id} para buscar livro expecifico")
    @GetMapping("/buscar/{idLivro}")
    public LivroResponseDTO listarLivroPorId(@PathVariable Long idLivro){
        return livroService.listarLivroPorId(idLivro);
    }

    @Operation(summary = "PUT{id} para atualizar livro expecifico")
    @PutMapping("/atualizar/{idLivro}")
    public LivroResponseDTO atualizarLivros(@PathVariable Long idLivro, @Valid  @RequestBody LivroRequestDTO dto){
        return livroService.atualizarLivro(idLivro, dto);
    }
}

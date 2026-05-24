package com.example.biblioteca.controller;

import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.dto.LivroResquestDTO;
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

    @Operation(summary = "GET simples do para lisatr todos os livros")
    @GetMapping
    public List<LivroResponseDTO> listarTodosLivros(){
        return livroService.listarTodosLivros();
    }

    @Operation
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroResponseDTO cadastrarLivros(@Valid @RequestBody LivroResquestDTO dto){
    return livroService.cadastrarLivros(dto);
    }
}

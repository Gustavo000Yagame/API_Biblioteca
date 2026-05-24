package com.example.biblioteca.controller;

import com.example.biblioteca.service.AutorService;
import com.example.biblioteca.dto.AutorResponseDTO;
import com.example.biblioteca.dto.AutorResquestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Autores", description = "Rotas de gerencimento dos autores")
@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @Operation(summary = "GET para listar todos os autores")
    @GetMapping
    public List<AutorResponseDTO> listarTodosAutores(){
        return autorService.listarTodosAutores();
    }

    @Operation(summary = "POST para cadastro de autores")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorResponseDTO cadastrarAutor(@Valid @RequestBody AutorResquestDTO dto){
        return autorService.cadastrarAutor(dto);
    }

    @Operation(summary = "GET com filtro {idAutor} para buscar autores expecificos")
    @GetMapping("/buscar/{idAutor}")
    public AutorResponseDTO buscarAutorPorId(@PathVariable Long idAutor){
        return autorService.buscarAutorPorId(idAutor);
    }

    @Operation(summary = "PUT para atualizar os nossos Amigos autores", description = "esqueci de mencinar mas escolhemos qual queremos att atravez do id")
    @PutMapping("/atualizar/{idAutor}")
    public AutorResponseDTO atualizarAutores(@PathVariable Long idAutor, @Valid @RequestBody AutorResquestDTO dto){
        return autorService.atualizarAutores(idAutor, dto);
    }

    @Operation(summary = "Delete para Matar os autores da humanidade")
    @DeleteMapping("/deletar/{idAutor}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAutor(@PathVariable Long idAutor){
        autorService.deletarAutor(idAutor);
    }
}

package com.example.biblioteca.service;

import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.dto.AutorResponseDTO;
import com.example.biblioteca.dto.AutorResquestDTO;
import com.example.biblioteca.model.Autor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Tag(name = "Service do Autor", description = "Responsavel pelos metodos que serao chamados no controller")
@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    @Operation(summary = "Conversor para os DTO")
    private AutorResponseDTO converteParaResponse(Autor autor){
        return new AutorResponseDTO(
                autor.getIdAutor(),
                autor.getNome(),
                autor.getNacionalidade(),
                autor.getTelefone(),
                autor.getEmail()
        );
    }

    @Operation(summary = "Metodo para cadastrar os autores")
    public AutorResponseDTO cadastrarAutor(AutorResquestDTO dto){
        Autor autor = new Autor();

        autor.setNome(dto.nome());
        autor.setNacionalidade(dto.nacionalidade());
        autor.setTelefone(dto.telefone());
        autor.setEmail(dto.email());

        Autor salvo = autorRepository.save(autor);
        return converteParaResponse(salvo);
    }

    @Operation(summary = "Metodo que lista todos os autores")
    public List<AutorResponseDTO> listarTodosAutores(){
        return autorRepository.findAll()
                .stream()
                .map(this::converteParaResponse)
                .toList();
    }

    @Operation(summary = "Metodo que busca os autores por id")
    public AutorResponseDTO buscarAutorPorId(Long idAutor){
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new RuntimeException("Autor nao encontrado"));
        return converteParaResponse(autor);
    }
}

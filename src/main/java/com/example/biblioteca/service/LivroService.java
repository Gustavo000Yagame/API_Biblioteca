package com.example.biblioteca.service;

import com.example.biblioteca.dto.LivroResponseDTO;
import com.example.biblioteca.dto.LivroRequestDTO;
import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.LivroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Tag(name = "Service dos livros", description = "Bla bla bla, basicamente metodos que serao chamados no controler")
@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    @Operation(summary = "Conversor para que a bosta do DTO entenda")
    private LivroResponseDTO converterToResponse(Livro livro) {
        return new LivroResponseDTO(
                livro.getIdLivro(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getAnoPublicacao(),
                livro.getAutor().getIdAutor(),
                livro.getAutor().getNome()
        );
    }

    @Operation(summary = "Metodo para listar os livros 🤯🤯🤯🤯🤯🤯🤯🤯🤯")
    public List<LivroResponseDTO> listarTodosLivros() {
        return livroRepository.findAll()
                .stream()
                .map(this::converterToResponse)
                .toList();
    }

    @Operation(summary = "Busca por ID dos livros ")
    public LivroResponseDTO listarLivroPorId(Long idLivro) {
        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado: " + idLivro));
        return converterToResponse(livro);
    }

    @Operation(summary = "Metodo para cadastrar livros")
    public LivroResponseDTO cadastrarLivros(LivroRequestDTO dto) {

        Autor autor = autorRepository.findById(dto.autorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado: " + dto.autorId()));

        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setAnoPublicacao(dto.anoPublicacao());
        livro.setAutor(autor);

        Livro livroSalvo = livroRepository.save(livro);
        return converterToResponse(livroSalvo); //carai foi uma desgraca fzr esse prr de metodo de cadastro slc
    }

    public LivroResponseDTO atualizarLivro(Long idLivro, LivroRequestDTO dto) {
        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado: " + idLivro));

        Autor autor = autorRepository.findById(dto.autorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado: " + dto.autorId()));

        livro.setTitulo(dto.titulo());
        livro.setIsbn(dto.isbn());
        livro.setAnoPublicacao(dto.anoPublicacao());
        livro.setAutor(autor);

        Livro novoLivro = livroRepository.save(livro);
        return converterToResponse(novoLivro);

    }
}

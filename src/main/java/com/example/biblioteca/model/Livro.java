package com.example.biblioteca.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "TBLivro")
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Livro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idLivro;

    private String titulo;


    @Column(unique = true, nullable = false)
    private String isbn;

    private Integer anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

}

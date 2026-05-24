package com.example.biblioteca.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "TBAutor")
@Getter @Setter
@Entity
@NoArgsConstructor
public class Autor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long idAutor;

    @Column(nullable = false, length = 50)
    private String nome;

    private String nacionalidade;

    @Column(unique = true, length = 10)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livros;

}

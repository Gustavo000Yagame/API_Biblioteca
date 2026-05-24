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
    private Long idAutor;

    private String nome;

    private String nacionalidade;

    private String telefone;

    private String email;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livros;

}

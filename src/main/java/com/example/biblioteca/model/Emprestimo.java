package com.example.biblioteca.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Table(name = "TBEmprestimo")
@Setter @Getter
@Entity
@NoArgsConstructor
public class Emprestimo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idEmprestimo;

    private String nomeLeitor;

    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;

    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    private String status;


    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

}

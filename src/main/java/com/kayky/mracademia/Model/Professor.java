package com.kayky.mracademia.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "tb_usuario", nullable = false)
    private Usuario usuario;
}

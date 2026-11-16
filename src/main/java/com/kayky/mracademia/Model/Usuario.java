package com.kayky.mracademia.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "tb_professor", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "tb_plano", nullable = false)
    private Plano plano;

    @ManyToOne
    @JoinColumn(name = "tb_horarios", nullable = false)
    private Horarios horarios;

    @ManyToOne
    @JoinTable(name = "tb_usuario_dias", joinColumns = @JoinColumn(name = "tb_usuario"), inverseJoinColumns = @JoinColumn(name = "tb_dias"))
    private List<Dias> diasTreino;


}

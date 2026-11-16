package com.kayky.mracademia.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_dias")
public class Dias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}

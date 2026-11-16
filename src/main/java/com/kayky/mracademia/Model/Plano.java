package com.kayky.mracademia.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

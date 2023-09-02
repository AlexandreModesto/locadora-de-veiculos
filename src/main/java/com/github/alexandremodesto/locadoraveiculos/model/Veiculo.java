package com.github.alexandremodesto.locadoraveiculos.model;

import javax.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String placa;

    @Column
    private String cor;
}

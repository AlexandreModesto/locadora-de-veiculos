package com.github.alexandremodesto.locadoraveiculos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Veiculo{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String placa;

    @Column
    private String cor;
}

package com.github.alexandremodesto.locadoraveiculos.model;


import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carro extends Veiculo {


    @Column
    private int portas;

    @Column
    private double motor;

    @Column
    private Boolean isFlex;

    @Column
    private String combustivel;

}

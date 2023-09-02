package com.github.alexandremodesto.locadoraveiculos.model;


import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Moto extends Veiculo {


    @Column
    private int cilindradas;


}

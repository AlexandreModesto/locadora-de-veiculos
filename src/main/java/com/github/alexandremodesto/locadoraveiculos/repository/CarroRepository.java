package com.github.alexandremodesto.locadoraveiculos.repository;

import com.github.alexandremodesto.locadoraveiculos.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro,Long> {

}

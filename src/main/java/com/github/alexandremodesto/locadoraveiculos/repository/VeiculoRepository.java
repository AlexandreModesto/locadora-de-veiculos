package com.github.alexandremodesto.locadoraveiculos.repository;

import com.github.alexandremodesto.locadoraveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

}

package com.github.alexandremodesto.locadoraveiculos.repository;

import com.github.alexandremodesto.locadoraveiculos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}

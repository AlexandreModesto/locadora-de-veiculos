package com.github.alexandremodesto.locadoraveiculos.service;

import com.github.alexandremodesto.locadoraveiculos.model.Veiculo;
import com.github.alexandremodesto.locadoraveiculos.model.Veiculo;
import com.github.alexandremodesto.locadoraveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    VeiculoRepository repository;
    public void salvarVeiculo(Veiculo objVeiculo){
        repository.save(objVeiculo);
    }
    public void deleteVeiculoById(Long id){
        repository.deleteById(id);
    }

    public Optional<Veiculo> getVeiculoById(Long id){
        return repository.findById(id);
    }

}

package com.github.alexandremodesto.locadoraveiculos.service;

import com.github.alexandremodesto.locadoraveiculos.model.Carro;
import com.github.alexandremodesto.locadoraveiculos.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    CarroRepository repository;
    public void salvarCarro(Carro objCarro){
        repository.save(objCarro);
    }
    public void deleteCarroById(Long id){
        repository.deleteById(id);
    }

    public Optional<Carro> getCarroById(Long id){
        return repository.findById(id);
    }

}

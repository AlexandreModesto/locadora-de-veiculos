package com.github.alexandremodesto.locadoraveiculos.service;

import com.github.alexandremodesto.locadoraveiculos.model.Moto;
import com.github.alexandremodesto.locadoraveiculos.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotoService {
    @Autowired
    MotoRepository repository;
    public void salvarMoto(Moto objMoto){
        repository.save(objMoto);
    }
    public void deleteMotoById(Long id){
        repository.deleteById(id);
    }

    public Optional<Moto> getMotoById(Long id){
        return repository.findById(id);
    }

}

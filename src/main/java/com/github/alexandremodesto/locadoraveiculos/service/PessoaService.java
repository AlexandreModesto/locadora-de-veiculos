package com.github.alexandremodesto.locadoraveiculos.service;

import com.github.alexandremodesto.locadoraveiculos.model.Pessoa;
import com.github.alexandremodesto.locadoraveiculos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> recuperarPorId(Long id){
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> recuperarTodos(){
        return pessoaRepository.findAll();
    }

    public void deletar(Long id){
        pessoaRepository.deleteById(id);
    }

}

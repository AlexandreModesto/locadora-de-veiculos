package com.github.alexandremodesto.locadoraveiculos.controller;

import com.github.alexandremodesto.locadoraveiculos.model.Pessoa;
import com.github.alexandremodesto.locadoraveiculos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping("/salvar")
    public ResponseEntity<Object> salvarPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.salvar(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> recuperarPessoaPorId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.recuperarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> recuperarTodasPessoasCadastradas() {
        List<Pessoa> pessoasCadastradas = pessoaService.recuperarTodos();
        return ResponseEntity.ok(pessoasCadastradas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPessoa(@PathVariable(value = "id") Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body("pessoa deletada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPesoa(@PathVariable(value = "id") Long id,
                                                 @RequestBody Pessoa pessoaParam) {
        var pessoa = pessoaService.recuperarPorId(id).get();
        pessoa.setCpf(pessoaParam.getCpf());
        pessoa.setNome(pessoaParam.getNome());
        pessoa.setEmail(pessoaParam.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.salvar(pessoa));
    }

}

package com.github.alexandremodesto.locadoraveiculos.controller;

import com.github.alexandremodesto.locadoraveiculos.model.Veiculo;
import com.github.alexandremodesto.locadoraveiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/Veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService service;

    @PostMapping(value = "/salvar")
    public ResponseEntity<?> salvarVeiculo(@RequestBody Veiculo objVeiculo){
        service.salvarVeiculo(objVeiculo);
        return ResponseEntity.status(HttpStatus.OK).body("Criado");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable (value = "id") Long id){
        service.deleteVeiculoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado");
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<?> getVeiculo(@PathVariable (value = "id") Long id){
        Optional<Veiculo> carro = service.getVeiculoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carro.get());
    }


    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateCarro(@RequestBody Veiculo objVeiculo, @PathVariable (value = "id") Long id){
        Optional<Veiculo> veiculoDesatualizado = service.getVeiculoById(id);
        var veiculoAtualizado = veiculoDesatualizado.get();
        veiculoAtualizado.setCor(objVeiculo.getCor());
        veiculoAtualizado.setPlaca(objVeiculo.getPlaca());
        service.salvarVeiculo(veiculoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoAtualizado.getId()+" Atualizado");
    }

}

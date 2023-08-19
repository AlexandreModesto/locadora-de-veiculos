package com.github.alexandremodesto.locadoraveiculos.controller;

import com.github.alexandremodesto.locadoraveiculos.model.Carro;
import com.github.alexandremodesto.locadoraveiculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/carros")
public class CarroController {

    @Autowired
    CarroService service;

    @PostMapping(value = "/salvar")
    public ResponseEntity<?> salvarCarro(@RequestBody Carro objCarro){
        service.salvarCarro(objCarro);
        return ResponseEntity.status(HttpStatus.OK).body("Criado");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCarroById(@PathVariable (value = "id") Long id){
        service.deleteCarroById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado");
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<?> getCarroById(@PathVariable (value = "id") Long id){
        Optional<Carro> carro = service.getCarroById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carro.get());
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateCarro(@RequestBody Carro objCarro, @PathVariable (value = "id") Long id){
        Optional<Carro> carroDesatualizado = service.getCarroById(id);
        var carroAtualizado = carroDesatualizado.get();
        carroAtualizado.setCombustivel(objCarro.getCombustivel());
        carroAtualizado.setCor(objCarro.getCor());
        carroAtualizado.setFlex(objCarro.getFlex());
        carroAtualizado.setMotor(objCarro.getMotor());
        carroAtualizado.setPlaca(objCarro.getPlaca());
        carroAtualizado.setPortas(objCarro.getPortas());
        service.salvarCarro(carroAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(carroAtualizado.getId()+" Atualizado");
    }

}

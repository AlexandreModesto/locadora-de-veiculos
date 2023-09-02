package com.github.alexandremodesto.locadoraveiculos.controller;

import com.github.alexandremodesto.locadoraveiculos.model.Moto;
import com.github.alexandremodesto.locadoraveiculos.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/Moto")
public class MotoController {

    @Autowired
    MotoService service;

    @PostMapping(value = "/salvar")
    public ResponseEntity<?> salvarMoto(@RequestBody Moto objMoto){
        service.salvarMoto(objMoto);
        return ResponseEntity.status(HttpStatus.OK).body("Criado");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteMotoById(@PathVariable (value = "id") Long id){
        service.deleteMotoById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado");
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getMotoById(@PathVariable (value = "id") Long id){
        Optional<Moto> moto = service.getMotoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(moto.get());
    }


    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateMoto(@RequestBody Moto objMoto, @PathVariable (value = "id") Long id){
        Optional<Moto> motoDesatualizado = service.getMotoById(id);
        var motoAtualizado = motoDesatualizado.get();
        motoAtualizado.setCilindradas(objMoto.getCilindradas());
        motoAtualizado.setPlaca(objMoto.getPlaca());
        motoAtualizado.setCor(objMoto.getCor());
        service.salvarMoto(motoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(motoAtualizado.getId()+" Atualizado");
    }

}

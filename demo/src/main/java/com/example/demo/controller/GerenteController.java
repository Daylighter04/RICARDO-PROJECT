package com.example.demo.controller;

import com.example.demo.model.Gerente;
import com.example.demo.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    GerenteRepository gerenteRepository;

    @GetMapping
    public List<Gerente> listarGerentes() {
        return gerenteRepository.findAll();
    }

    @PutMapping("/id")
    public ResponseEntity<Gerente> atualizar (@PathVariable long id, RequestBody Gerente gerente){
        if(gerenteRepository.existsById(id)) {
            gerente.setId(id);
            return gerenteRepository.save(gerente);

        } else {
            return null;
        }
    }
    @PostMapping
    public Gerente criar(@RequestBody Gerente gerente) {return gerenteRepository.save(gerente);}

}




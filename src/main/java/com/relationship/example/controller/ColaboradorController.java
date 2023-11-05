package com.relationship.example.controller;

import com.relationship.example.model.Colaborador;
import com.relationship.example.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @GetMapping
    public List<Colaborador> getAllColaboradores(){
        return colaboradorRepository.findAll();
    }

    @PostMapping
    public Colaborador createColaborador(@RequestBody Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }
}

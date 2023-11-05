package com.relationship.example.controller;

import com.relationship.example.model.Cargo;
import com.relationship.example.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public List<Cargo> getAllCargos(){
        return cargoRepository.findAll();
    }

    @PostMapping
    public Cargo createCargo(@RequestBody Cargo cargo){
        return cargoRepository.save(cargo);
    }


}

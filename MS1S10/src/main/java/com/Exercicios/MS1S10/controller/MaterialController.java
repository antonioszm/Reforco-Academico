package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Material;
import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.errors.MaterialNotFoundException;
import com.Exercicios.MS1S10.errors.TutorNotFoundException;
import com.Exercicios.MS1S10.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialService service;

    @GetMapping
    public List<Material> listarTodos(){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Material listarPorId(@PathVariable Long id){
        List<Material> listaDeMateriais = service.listarTodos();
        for (Material material : listaDeMateriais){
            if (material.getId().equals(id)){
                ResponseEntity.status(HttpStatus.OK);
                return service.listarPorId(id);
            } else {
                throw new MaterialNotFoundException(id);
            }
        }
        return null;
    }

    @PostMapping
    public Material salvar(@RequestBody Material material){
        ResponseEntity.status(HttpStatus.CREATED);
        return service.salvar(material);
    }

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){
        List<Material> listaDeMateriais = service.listarTodos();
        for (Material materiais : listaDeMateriais){
            if (materiais.getId().equals(id)){
                service.removerPorId(id);
                ResponseEntity.status(HttpStatus.NO_CONTENT);
            } else {
                throw new MaterialNotFoundException(id);
            }
        }
    }

    @PutMapping
    public int atualizar(@RequestBody Material material){
        ResponseEntity.status(HttpStatus.OK);
        return service.atualizar(material);
    }
}

package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.errors.TutorNotFoundException;
import com.Exercicios.MS1S10.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    TutorService service;

    @GetMapping
    public List<Tutor> listarTodos(){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarTodos();
    }
    @GetMapping("/{id}")
    public Tutor listarPorId(@PathVariable Long id){
        List<Tutor> listaDeTutores = service.listarTodos();
        for (Tutor tutores : listaDeTutores){
            if (tutores.getId().equals(id)){
                ResponseEntity.status(HttpStatus.OK);
                return service.listarPorId(id);
            } else {
                throw new TutorNotFoundException(id);
            }
        }
        return null;
    }

    @PostMapping
    public Tutor salvar(@RequestBody Tutor tutor){
        ResponseEntity.status(HttpStatus.CREATED);
        return service.salvar(tutor);
    }

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){
        List<Tutor> listaDeTutores = service.listarTodos();
        for (Tutor tutores : listaDeTutores){
            if (tutores.getId().equals(id)){
                service.removerPorId(id);
                ResponseEntity.status(HttpStatus.NO_CONTENT);
            } else {
                throw new TutorNotFoundException(id);
            }
        }
    }

    @PutMapping
    public int atualizar(@RequestBody Tutor tutor){
        ResponseEntity.status(HttpStatus.OK);
        return service.atualizar(tutor);
    }
}

package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.errors.AlunoNotFoundException;
import com.Exercicios.MS1S10.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService service;

    @GetMapping
    public List<Aluno> listarTodos(){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarTodos();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        ResponseEntity.status(HttpStatus.CREATED);
        return service.salvar(aluno);
    }

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){
        List<Aluno> listaDeAlunos = new ArrayList<>();
        for (Aluno alunos : listaDeAlunos){
            if (alunos.getId().equals(id)){
                service.removerPorId(id);
                ResponseEntity.status(HttpStatus.NO_CONTENT);
            } else {
                throw new AlunoNotFoundException(id);
            }
        }
    }

    @PutMapping
    public int atualizar(@RequestBody Aluno aluno){
        ResponseEntity.status(HttpStatus.OK);
        return service.atualizar(aluno);
    }
}

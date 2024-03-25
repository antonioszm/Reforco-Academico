package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService service;

    @GetMapping
    public List<Aluno> listarTodos(){return service.listarTodos();}

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){return service.salvar(aluno);}

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){service.removerPorId(id);}

    @PutMapping
    public int atualizar(@RequestBody Aluno aluno){return service.atualizar(aluno);}
}

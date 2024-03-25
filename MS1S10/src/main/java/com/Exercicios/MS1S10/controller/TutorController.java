package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.service.AlunoService;
import com.Exercicios.MS1S10.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    TutorService service;

    @GetMapping
    public List<Tutor> listarTodos(){return service.listarTodos();}

    @PostMapping
    public Tutor salvar(@RequestBody Tutor tutor){return service.salvar(tutor);}

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){service.removerPorId(id);}

    @PutMapping
    public int atualizar(@RequestBody Tutor tutor){return service.atualizar(tutor);}
}

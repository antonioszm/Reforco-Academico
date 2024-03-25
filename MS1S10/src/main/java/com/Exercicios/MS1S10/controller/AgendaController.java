package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.service.AgendaService;
import com.Exercicios.MS1S10.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    AgendaService service;

    @GetMapping
    public List<Agenda> listarTodos(){return service.listarTodos();}

    @PostMapping
    public Agenda salvar(@RequestBody Agenda agenda){return service.salvar(agenda);}

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){service.removerPorId(id);}

    @PutMapping
    public int atualizar(@RequestBody Agenda agenda){return service.atualizar(agenda);}
}

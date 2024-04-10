package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.errors.AgendaNotFoundException;
import com.Exercicios.MS1S10.errors.AlunoNotFoundException;
import com.Exercicios.MS1S10.service.AgendaService;
import com.Exercicios.MS1S10.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    AgendaService service;

    @GetMapping
    public List<Agenda> listarTodos(){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Agenda listarPorId(@PathVariable Long id){
        List<Agenda> listaDeAgendas = service.listarTodos();
        for (Agenda agenda : listaDeAgendas){
            if (agenda.getId().equals(id)){
                ResponseEntity.status(HttpStatus.OK);
                return service.listarPorId(id);
            } else {
                throw new AgendaNotFoundException(id);
            }
        }
        return null;
    }

    @GetMapping("agendamentos/aluno-id/{id}")
    public List<Agenda> listarPorAlunoId(@PathVariable Long id){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarPorAlunoId(id);
    }

    @GetMapping("agendamentos/tutor-id/{id}")
    public List<Agenda> listarPorTutorId(@PathVariable Long id){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarPorTutorId(id);
    }

    @GetMapping("proximos-agendamentos/aluno-id/{id}")
    public List<Agenda> listarProximosAgendamentosAluno (@PathVariable Long id){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarProximosAgendamentosAluno(id);
    }

    @GetMapping("proximos-agendamentos/tutor-id/{id}")
    public List<Agenda> listarProximosAgendamentosTutor (@PathVariable Long id){
        ResponseEntity.status(HttpStatus.OK);
        return service.listarProximosAgendamentosTutor(id);
    }

    @PostMapping
    public Agenda salvar(@RequestBody Agenda agenda){
        ResponseEntity.status(HttpStatus.CREATED);
        return service.salvar(agenda);
    }

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){
        List<Agenda> listaDeAgendas = service.listarTodos();
        for (Agenda agenda : listaDeAgendas){
            if (agenda.getId().equals(id)){
                service.removerPorId(id);
                ResponseEntity.status(HttpStatus.NO_CONTENT);
            } else {
                throw new AgendaNotFoundException(id);
            }
        }
    }

    @PutMapping
    public int atualizar(@RequestBody Agenda agenda){
        ResponseEntity.status(HttpStatus.OK);
        return service.atualizar(agenda);
    }
}

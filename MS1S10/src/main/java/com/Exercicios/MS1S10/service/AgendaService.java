package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.repository.AgendalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AgendaService {
    @Autowired
    AgendalRepository repository;
    public List<Agenda> listarTodos(){return repository.findAll();}
    public Agenda salvar(Agenda agenda){
        return repository.save(agenda);
    }
    public void removerPorId(Long id){ repository.deleteById(id);}

    public int atualizar(Agenda agenda){
        return repository.update(agenda.getId(), agenda.getId_aluno(), agenda.getId_tutor(), agenda.getData(),agenda.getStatus(),agenda.getDescricaoBreve());
    }
}

package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.errors.AgendaNotFoundException;
import com.Exercicios.MS1S10.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    AgendaRepository repository;

    @Override
    public List<Agenda> listarTodos(){return repository.findAll();}

    @Override
    public Agenda listarPorId(long id){
        return repository.findById(id).orElseThrow(() -> new AgendaNotFoundException(id));
    }

    @Override
    public Agenda salvar(Agenda agenda){
        agenda.setId(null);
        return repository.save(agenda);
    }

    @Override
    public void removerPorId(Long id){
        Agenda agenda = listarPorId(id);
        repository.delete(agenda);
    }

    @Override
    public int atualizar(Agenda agenda){
        return repository.update(agenda.getId(), agenda.getId_aluno(), agenda.getId_tutor(), agenda.getData(),agenda.getStatus(),agenda.getDescricaoBreve());
    }
}

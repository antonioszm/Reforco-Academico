package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.errors.AgendaNotFoundException;
import com.Exercicios.MS1S10.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    AgendaRepository repository;

    @Override
    public List<Agenda> listarTodos(){return repository.findAll();}

    @Override
    public List<Agenda> listarPorAlunoId(Long id){
        List<Agenda> listaAgendas = listarTodos();
        List<Agenda> listaDeAgendamentosDoAluno = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_aluno().getId().equals(id)){
                listaDeAgendamentosDoAluno.add(agendas);
            }
        }

        Collections.sort(listaDeAgendamentosDoAluno, new Comparator<Agenda>() {
            @Override
            public int compare(Agenda o1, Agenda o2) {
                return o1.getData().compareTo(o2.getData());
            }
        });
        return listaDeAgendamentosDoAluno;
    }

    @Override
    public List<Agenda> listarProximosAgendamentosAluno(Long id){
        List<Agenda> listaAgendas = listarTodos();
        List<Agenda> listaDeAgendamentosDoAluno = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_aluno().getId().equals(id)){
                listaDeAgendamentosDoAluno.add(agendas);
            }
        }

        for (Agenda agendas : listaAgendas){
            boolean agendaProxima = agendas.getData().isAfter(LocalDate.now());
            if (!agendaProxima){
                listaDeAgendamentosDoAluno.remove(agendas);
            }
        }
        Collections.sort(listaDeAgendamentosDoAluno, new Comparator<Agenda>() {
            @Override
            public int compare(Agenda o1, Agenda o2) {
                return o1.getData().compareTo(o2.getData());
            }
        });
        return listaDeAgendamentosDoAluno;
    }

    @Override
    public List<Agenda> listarProximosAgendamentosTutor(Long id){
        List<Agenda> listaAgendas = listarTodos();
        List<Agenda> listaDeAgendamentosDoTutor = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_tutor().getId().equals(id)){
                listaDeAgendamentosDoTutor.add(agendas);
            }
        }


        for (Agenda agendas : listaAgendas){
            boolean agendaProxima = agendas.getData().isAfter(LocalDate.now());
            if (!agendaProxima){
                listaDeAgendamentosDoTutor.remove(agendas);
            }
        }
        Collections.sort(listaDeAgendamentosDoTutor, new Comparator<Agenda>() {
            @Override
            public int compare(Agenda o1, Agenda o2) {
                return o1.getData().compareTo(o2.getData());
            }
        });
        return listaDeAgendamentosDoTutor;
    }

    @Override
    public List<Agenda> listarPorTutorId(Long id){
        List<Agenda> listaAgendas = listarTodos();
        List<Agenda> listaDeAgendamentosDoTutor = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_tutor().getId().equals(id)){
                listaDeAgendamentosDoTutor.add(agendas);
            }
        }

        Collections.sort(listaDeAgendamentosDoTutor, new Comparator<Agenda>() {
            @Override
            public int compare(Agenda o1, Agenda o2) {
                return o1.getData().compareTo(o2.getData());
            }
        });
        return listaDeAgendamentosDoTutor;
    }

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

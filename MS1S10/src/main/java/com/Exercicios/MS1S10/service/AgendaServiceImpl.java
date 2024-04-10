package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.errors.AgendaNotFoundException;
import com.Exercicios.MS1S10.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Agenda> listaDeAgendamentosDoAlunoCresente = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_aluno().getId().equals(id)){
                listaDeAgendamentosDoAluno.add(agendas);
            }
        }
        for (Agenda agenda : listaDeAgendamentosDoAluno){
            boolean dataPosterior = true;
            for (Agenda agenda2 : listaDeAgendamentosDoAluno){
                if (agenda != agenda2 && agenda.getData().isBefore(agenda2.getData())) {
                    dataPosterior = false;
                    break;
                }
            }
            if (dataPosterior){listaDeAgendamentosDoAlunoCresente.add(agenda);}
        }
        return listaDeAgendamentosDoAlunoCresente;
    }

    @Override
    public List<Agenda> listarProximosAgendamentosAluno(Long id){
        List<Agenda> listaAgendas = listarTodos();
        List<Agenda> listaDeAgendamentosDoAluno = new ArrayList<>();
        List<Agenda> listaDeAgendamentosDoAlunoCresente = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_aluno().getId().equals(id)){
                listaDeAgendamentosDoAluno.add(agendas);
            }
        }
        for (Agenda agenda : listaDeAgendamentosDoAluno){
            boolean dataPosterior = true;
            for (Agenda agenda2 : listaDeAgendamentosDoAluno){
                if (agenda != agenda2 && agenda.getData().isBefore(agenda2.getData()) && agenda.getData().isAfter(LocalDate.now())){
                    dataPosterior = false;
                    break;
                }
            }
            if (dataPosterior){listaDeAgendamentosDoAlunoCresente.add(agenda);}
        }
        return listaDeAgendamentosDoAlunoCresente;
    }

    @Override
    public List<Agenda> listarProximosAgendamentosTutor(Long id){
        List<Agenda> listaAgendas = listarTodos();
        List<Agenda> listaDeAgendamentosDoTutor = new ArrayList<>();
        List<Agenda> listaDeAgendamentosDoTutorCresente = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_tutor().getId().equals(id)){
                listaDeAgendamentosDoTutor.add(agendas);
            }
        }
        for (Agenda agenda : listaDeAgendamentosDoTutor){
            boolean dataPosterior = true;
            for (Agenda agenda2 : listaDeAgendamentosDoTutor){
                if (agenda != agenda2 && agenda.getData().isBefore((agenda2.getData())) && agenda.getData().isAfter(LocalDate.now())){
                    dataPosterior = false;
                    break;
                }
            }
            if (dataPosterior){listaDeAgendamentosDoTutorCresente.add(agenda);}
        }
        return listaDeAgendamentosDoTutorCresente;
    }

    @Override
    public List<Agenda> listarPorTutorId(Long id){
        List<Agenda> listaAgendas = listarTodos();
        List<Agenda> listaDeAgendamentosDoTutor = new ArrayList<>();
        List<Agenda> listaDeAgendamentosDoTutorCresente = new ArrayList<>();
        for (Agenda agendas : listaAgendas){
            if (agendas.getId_tutor().getId().equals(id)){
                listaDeAgendamentosDoTutor.add(agendas);
            }
        }
        for (Agenda agenda : listaDeAgendamentosDoTutor){
            boolean dataPosterior = true;
            for (Agenda agenda2 : listaDeAgendamentosDoTutor){
                if (agenda != agenda2 && agenda.getData().isBefore((agenda2.getData()))) {
                    dataPosterior = false;
                    break;
                }
            }
            if (dataPosterior){listaDeAgendamentosDoTutorCresente.add(agenda);}
        }
        return listaDeAgendamentosDoTutorCresente;
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

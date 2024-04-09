package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AgendaService {

    public List<Agenda> listarTodos();

    public List<Agenda> listarPorAlunoId(Long id);
    public List<Agenda> listarPorTutorId(Long id);

    public List<Agenda> listarProximosAgendamentosAluno(Long id);
    public List<Agenda> listarProximosAgendamentosTutor(Long id);

    public Agenda listarPorId(long id);
    public Agenda salvar(Agenda agenda);
    public void removerPorId(Long id);
    public int atualizar(Agenda agenda);
}

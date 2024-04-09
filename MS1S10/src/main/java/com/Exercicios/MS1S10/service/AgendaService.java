package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AgendaService {

    public List<Agenda> listarTodos();

    public Agenda listarPorId(long id);
    public Agenda salvar(Agenda agenda);
    public void removerPorId(Long id);
    public int atualizar(Agenda agenda);
}

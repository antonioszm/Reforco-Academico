package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AlunoService {

    public List<Aluno> listarTodos();
    public Aluno salvar(Aluno aluno);

    public void removerPorId(Long id);
    public Aluno listarPorId(Long id);

    public int atualizar(Aluno aluno);
}

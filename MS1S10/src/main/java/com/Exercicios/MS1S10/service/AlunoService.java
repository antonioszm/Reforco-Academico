package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired

    AlunoRepository repository;
    public List<Aluno> listarTodos(){return repository.findAll();}
    public Aluno salvar(Aluno aluno){
        return repository.save(aluno);
    }
    public void removerPorId(Long id){ repository.deleteById(id);}

    public int atualizar(Aluno aluno){
        return repository.update(aluno.getId(), aluno.getNome());
    }
}

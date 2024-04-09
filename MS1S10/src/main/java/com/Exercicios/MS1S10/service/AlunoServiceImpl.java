package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.errors.AlunoNotFoundException;
import com.Exercicios.MS1S10.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    AlunoRepository repository;

    @Override
    public List<Aluno> listarTodos(){return repository.findAll();}

    @Override
    public Aluno salvar(Aluno aluno){
        aluno.setId(null);
        return repository.save(aluno);
    }

    @Override
    public void removerPorId(Long id){
        Aluno aluno = listarPorId(id);
        repository.delete(aluno);
    }

    @Override
    public Aluno listarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
    }

    @Override
    public int atualizar(Aluno aluno){
        return repository.update(aluno.getId(), aluno.getNome());
    }
}

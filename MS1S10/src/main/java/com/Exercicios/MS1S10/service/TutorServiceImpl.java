package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.errors.TutorNotFoundException;
import com.Exercicios.MS1S10.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
    @Autowired
    TutorRepository repository;

    @Override
    public List<Tutor> listarTodos(){return repository.findAll();}

    @Override
    public Tutor salvar(Tutor tutor){
        tutor.setId(null);
        return repository.save(tutor);
    }

    @Override
    public void removerPorId(Long id){
        Tutor tutor = listarPorId(id);
        repository.delete(tutor);
    }

    @Override
    public Tutor listarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new TutorNotFoundException(id));
    }

    @Override
    public int atualizar(Tutor tutor){
        return repository.update(tutor.getId(), tutor.getNome(), tutor.getEspecialidade());
    }
}

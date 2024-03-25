package com.Exercicios.MS1S10.service;


import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    @Autowired
    TutorRepository repository;
    public List<Tutor> listarTodos(){return repository.findAll();}
    public Tutor salvar(Tutor tutor){
        return repository.save(tutor);
    }
    public void removerPorId(Long id){ repository.deleteById(id);}

    public int atualizar(Tutor tutor){
        return repository.update(tutor.getId(),tutor.getNome(), tutor.getEspecialidade());
    }
}

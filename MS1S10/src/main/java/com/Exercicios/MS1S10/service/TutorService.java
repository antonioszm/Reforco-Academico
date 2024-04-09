package com.Exercicios.MS1S10.service;


import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TutorService {
    public List<Tutor> listarTodos();
    public Tutor salvar(Tutor tutor);
    public void removerPorId(Long id);
    public Tutor listarPorId(Long id);

    public int atualizar(Tutor tutor);
}

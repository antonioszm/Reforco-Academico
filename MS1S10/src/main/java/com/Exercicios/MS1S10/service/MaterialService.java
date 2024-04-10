package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Material;
import com.Exercicios.MS1S10.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MaterialService {

    public List<Material> listarTodos();
    public Material salvar(Material material);
    public void removerPorId(Long id);
    public Material listarPorId(Long id);

    public int atualizar(Material material);
}

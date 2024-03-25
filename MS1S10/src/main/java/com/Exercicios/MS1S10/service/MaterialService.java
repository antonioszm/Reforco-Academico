package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Material;
import com.Exercicios.MS1S10.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired

    MaterialRepository repository;
    public List<Material> listarTodos(){return repository.findAll();}
    public Material salvar(Material material){
        return repository.save(material);
    }
    public void removerPorId(Long id){ repository.deleteById(id);}

    public int atualizar(Material material){
        return repository.update(material.getId(), material.getId_agenda(), material.getDescricao(),material.getCaminhoDoArquivo());
    }
}

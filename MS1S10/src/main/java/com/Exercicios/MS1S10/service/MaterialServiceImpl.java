package com.Exercicios.MS1S10.service;

import com.Exercicios.MS1S10.entities.Material;
import com.Exercicios.MS1S10.errors.MaterialNotFoundException;
import com.Exercicios.MS1S10.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialRepository repository;

    @Override
    public List<Material> listarTodos(){return repository.findAll();}

    @Override
    public Material salvar(Material material){
        material.setId(null);
        return repository.save(material);
    }

    @Override
    public void removerPorId(Long id){
        Material material = listarPorId(id);
        repository.delete(material);
    }

    @Override
    public Material listarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new MaterialNotFoundException(id));
    }

    @Override
    public int atualizar(Material material){
        return repository.update(material.getId(), material.getId_agenda(), material.getDescricao(), material.getCaminhoDoArquivo());
    }
}

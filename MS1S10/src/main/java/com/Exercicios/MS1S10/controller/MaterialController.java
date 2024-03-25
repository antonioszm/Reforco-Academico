package com.Exercicios.MS1S10.controller;

import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.entities.Material;
import com.Exercicios.MS1S10.service.AlunoService;
import com.Exercicios.MS1S10.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    MaterialService service;

    @GetMapping
    public List<Material> listarTodos(){return service.listarTodos();}

    @PostMapping
    public Material salvar(@RequestBody Material material){return service.salvar(material);}

    @DeleteMapping("/{id}")
    public void removerPorId(@PathVariable Long id){service.removerPorId(id);}

    @PutMapping
    public int atualizar(@RequestBody Material material){return service.atualizar(material);}
}

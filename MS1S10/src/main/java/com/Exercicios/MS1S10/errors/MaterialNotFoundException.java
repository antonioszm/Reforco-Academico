package com.Exercicios.MS1S10.errors;


public class MaterialNotFoundException extends NotFoundException {
    public MaterialNotFoundException(long id){
        super("Material com o id " + id + " não encontrado");
    }
}


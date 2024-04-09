package com.Exercicios.MS1S10.errors;


public class AlunoNotFoundException extends NotFoundException {
    public AlunoNotFoundException(long id){
        super("Aluno com o id " + id + " não encontrado");
    }
}

package com.Exercicios.MS1S10.errors;


public class TutorNotFoundException extends NotFoundException {
    public TutorNotFoundException(long id){
        super("Tutor com o id " + id + " não encontrado");
    }
}


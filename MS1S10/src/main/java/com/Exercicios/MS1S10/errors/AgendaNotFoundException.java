package com.Exercicios.MS1S10.errors;


public class AgendaNotFoundException extends NotFoundException {
    public AgendaNotFoundException(long id){
        super("Agenda com o id " + id + " não encontrado");
    }
}

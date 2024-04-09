package com.Exercicios.MS1S10.errors;


public abstract class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }
    public NotFoundException(String message) {
            super(message);
    }

}
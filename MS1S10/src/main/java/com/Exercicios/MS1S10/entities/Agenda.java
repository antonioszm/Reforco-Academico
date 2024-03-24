package com.Exercicios.MS1S10.entities;

import com.Exercicios.MS1S10.enuns.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long id_Aluno;
    private long id_Tutor;
    private Date data;
    private Status status;
    private String tema;
    private String descriçãoBreve;
}

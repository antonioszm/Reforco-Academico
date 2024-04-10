package com.Exercicios.MS1S10.entities;

import com.Exercicios.MS1S10.enuns.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno id_aluno;
    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false)
    private Tutor id_tutor;

    private LocalDate data;
    private Status status;
    private String tema;
    private String descricaoBreve;
}

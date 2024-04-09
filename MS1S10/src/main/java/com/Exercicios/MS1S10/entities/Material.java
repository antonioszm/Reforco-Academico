package com.Exercicios.MS1S10.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_agenda", nullable = false)
    private Agenda id_agenda;
    private String descricao;
    private String caminhoDoArquivo;

}

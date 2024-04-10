package com.Exercicios.MS1S10.repository;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.entities.Tutor;
import com.Exercicios.MS1S10.enuns.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Agenda SET id_aluno = :id_aluno, id_tutor = :id_tutor, data = :data, status = :status, tema = :tema, descricao_breve = :descricaoBreve  WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("id_aluno") Aluno id_aluno,
               @Param("id_tutor") Tutor id_tutor,
               @Param("data") LocalDate data,
               @Param("status")Status status,
               @Param("descricaoBreve") String descricaoBreve
               );
}

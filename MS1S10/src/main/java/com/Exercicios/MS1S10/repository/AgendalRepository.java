package com.Exercicios.MS1S10.repository;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.enuns.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AgendalRepository extends JpaRepository<Agenda, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Agenda SET id_aluno = :id_aluno, id_tutor = :id_tutor, data = :data, status = :status, tema = :tema, descricao_breve = :descricaoBreve  WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("id_aluno") Long id_aluno,
               @Param("id_tutor") Long id_tutor,
               @Param("data") Date data,
               @Param("status")Status status,
               @Param("descricaoBreve") String descricaoBreve
               );
}
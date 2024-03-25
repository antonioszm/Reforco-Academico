package com.Exercicios.MS1S10.repository;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Aluno;
import com.Exercicios.MS1S10.enuns.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Aluno SET nome = :nome  WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("nome") String nome
    );
}

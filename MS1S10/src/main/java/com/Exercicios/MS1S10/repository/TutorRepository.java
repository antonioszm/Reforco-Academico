package com.Exercicios.MS1S10.repository;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Tutor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Aluno SET nome = :nome, especialidade = :especialidade  WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("nome") String nome,
               @Param("especialidade") String especialidade
    );
}

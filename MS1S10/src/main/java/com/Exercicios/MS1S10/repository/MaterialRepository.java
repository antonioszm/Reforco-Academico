package com.Exercicios.MS1S10.repository;

import com.Exercicios.MS1S10.entities.Agenda;
import com.Exercicios.MS1S10.entities.Material;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Material SET id_agenda = :id_agenda, descricao = :descricao, caminho_do_arquivo = :caminhoDoArquivo  WHERE id = :id", nativeQuery = true)
    int update(@Param("id") Long id,
               @Param("id_agenda") Agenda id_agenda,
               @Param("descricao") String descricao,
               @Param("caminhoDoArquivo") String caminhoDoArquivo
    );
}

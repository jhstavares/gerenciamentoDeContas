package com.desafio.gerenciamentoDeContas.repository;

import com.desafio.gerenciamentoDeContas.model.ContasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasRepository extends JpaRepository<ContasModel, Long> {

}

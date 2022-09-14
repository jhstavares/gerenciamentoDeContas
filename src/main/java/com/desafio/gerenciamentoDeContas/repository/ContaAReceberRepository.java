package com.desafio.gerenciamentoDeContas.repository;

import com.desafio.gerenciamentoDeContas.model.ContaAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaAReceberRepository extends JpaRepository<ContaAReceberModel, Long> {
}


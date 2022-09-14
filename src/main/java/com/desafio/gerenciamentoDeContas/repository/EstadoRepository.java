package com.desafio.gerenciamentoDeContas.repository;

import com.desafio.gerenciamentoDeContas.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
}

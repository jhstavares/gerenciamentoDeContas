package com.desafio.gerenciamentoDeContas.repository;

import com.desafio.gerenciamentoDeContas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsurioRepository extends JpaRepository<UsuarioModel, Long> {
}

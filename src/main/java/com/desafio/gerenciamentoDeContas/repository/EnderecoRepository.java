package com.desafio.gerenciamentoDeContas.repository;

import com.desafio.gerenciamentoDeContas.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

}

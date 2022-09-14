package com.desafio.gerenciamentoDeContas.service;

import com.desafio.gerenciamentoDeContas.model.ContaAReceberModel;
import com.desafio.gerenciamentoDeContas.repository.ContaAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaAReceberService {
    @Autowired
    private ContaAReceberRepository repository;

    public List<ContaAReceberModel> buscarTodasContaAReceber() {
        return repository.findAll();
    }

    public Optional<ContaAReceberModel> buscarPorId(Long codigoContaAReceber) {
        return repository.findById(codigoContaAReceber);
    }

    public ContaAReceberModel cadastrar(ContaAReceberModel conta) {


        return repository.save(conta);
    }

    public ContaAReceberModel alterar(ContaAReceberModel conta) {


        return repository.save(conta);
    }

    public void deletar(Long codigoContaAReceber) {
        repository.deleteById(codigoContaAReceber);
    }
}



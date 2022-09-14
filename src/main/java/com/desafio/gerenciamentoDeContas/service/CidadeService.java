package com.desafio.gerenciamentoDeContas.service;

import com.desafio.gerenciamentoDeContas.model.CidadeModel;
import com.desafio.gerenciamentoDeContas.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<CidadeModel> buscarTodasCidades() {
        return repository.findAll();
    }

    public Optional<CidadeModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public CidadeModel cadastrar(CidadeModel cidade) {


        return repository.save(cidade);
    }

    public CidadeModel alterar(CidadeModel cidade) {


        return repository.save(cidade);

    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

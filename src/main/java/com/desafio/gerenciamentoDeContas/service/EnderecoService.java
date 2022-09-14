package com.desafio.gerenciamentoDeContas.service;

import com.desafio.gerenciamentoDeContas.model.EnderecoModel;
import com.desafio.gerenciamentoDeContas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoModel> buscarTodosEndereco() {
        return repository.findAll();
    }

    public Optional<EnderecoModel> buscarPorId(Long codigoDoEndereco) {
        return repository.findById(codigoDoEndereco);
    }

    public EnderecoModel cadastrar(EnderecoModel endereco) {


        return repository.save(endereco);

    }

    public EnderecoModel alterar(EnderecoModel endereco) {


        return repository.save(endereco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}



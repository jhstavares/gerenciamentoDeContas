package com.desafio.gerenciamentoDeContas.service;

import com.desafio.gerenciamentoDeContas.model.EnderecoModel;
import com.desafio.gerenciamentoDeContas.model.EstadoModel;
import com.desafio.gerenciamentoDeContas.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<EstadoModel> buscarToodosEstados() {
        return repository.findAll();
    }

    public Optional buscarPorId(Long codigoDoEstado) {
        return repository.findById(codigoDoEstado);
    }

    public EstadoModel cadastrar(EstadoModel estado) {


        return repository.save(estado);
    }

    public EstadoModel alterar(EstadoModel estado) {


        return repository.save(estado);


    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }


}

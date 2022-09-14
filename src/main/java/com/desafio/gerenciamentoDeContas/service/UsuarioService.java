package com.desafio.gerenciamentoDeContas.service;

import com.desafio.gerenciamentoDeContas.model.UsuarioModel;
import com.desafio.gerenciamentoDeContas.repository.UsurioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsurioRepository repository;

    public List<UsuarioModel> buscarTodosUsuario() {
        return repository.findAll();
    }

    public Optional<UsuarioModel> buscarPorId(Long codigoDoUsuario) {
        return repository.findById(codigoDoUsuario);

    }

    public UsuarioModel cadastrar(UsuarioModel usuario) {


        return repository.save(usuario);
    }

    public UsuarioModel alterar(UsuarioModel usuario) {


        return repository.save(usuario);

    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }


}

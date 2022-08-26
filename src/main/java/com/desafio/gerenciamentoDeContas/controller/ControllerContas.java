package com.desafio.gerenciamentoDeContas.controller;

import com.desafio.gerenciamentoDeContas.model.ModelContas;
import com.desafio.gerenciamentoDeContas.model.ResponseModel;
import com.desafio.gerenciamentoDeContas.repository.RepositoryContas;
import com.desafio.gerenciamentoDeContas.service.ServiceContas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ControllerContas {

    @Autowired
    private ServiceContas serviceContas;

    @Autowired
    private RepositoryContas repositoryContas;

    @GetMapping(path = "/contas")
    public ResponseEntity<List<ResponseModel>> buscarTodasAsContas() {
        return ResponseEntity.ok(serviceContas.buscarTodasAsContas());

    }

    @GetMapping(path = "/contas/{id}")
    public Optional<ModelContas> buscarContasPorId(@PathVariable Long id) {
        return serviceContas.buscarContasPorId(id);

    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ModelContas> cadastrarContas(@RequestBody ModelContas contas) {
        ModelContas contas1 = serviceContas.cadastrar(contas);

        return new ResponseEntity<>(contas1, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/contas/{id}")
    public ResponseEntity<ModelContas> atualizarConta(@PathVariable Long id, @RequestBody ModelContas contas) {
        return ResponseEntity.ok(serviceContas.atualizar(contas));
    }

    @DeleteMapping(path = "/contas/{id}")
    public ResponseEntity deletarConta(@PathVariable Long id) {

        if (!repositoryContas.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        serviceContas.deletar(id);
        return null;
    }


}







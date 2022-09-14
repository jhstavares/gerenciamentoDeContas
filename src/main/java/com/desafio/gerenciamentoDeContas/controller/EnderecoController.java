package com.desafio.gerenciamentoDeContas.controller;

import com.desafio.gerenciamentoDeContas.model.EnderecoModel;
import com.desafio.gerenciamentoDeContas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/endereco")
@Valid
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> buscarEndereco() {
        return ResponseEntity.ok(service.buscarTodosEndereco());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<EnderecoModel>> buscarPorId(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/endereco")
    public EnderecoModel cadastrarEndereco(@Valid @RequestBody EnderecoModel endereco) {
        return service.cadastrar(endereco);

    }

    @PutMapping("{id}")
    public ResponseEntity<EnderecoModel> alterarEndereco(@Valid @RequestBody EnderecoModel endereco) {
        return ResponseEntity.ok(service.alterar(endereco));
    }

    @DeleteMapping(path = "{id}")
    public void deletarEndereco(@PathVariable Long id) {
        service.deletar(id);

    }

}

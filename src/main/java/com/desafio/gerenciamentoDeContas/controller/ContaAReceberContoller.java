package com.desafio.gerenciamentoDeContas.controller;

import com.desafio.gerenciamentoDeContas.model.ContaAReceberModel;
import com.desafio.gerenciamentoDeContas.service.ContaAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/conta")
@Validated
public class ContaAReceberContoller {
    @Autowired
    private ContaAReceberService service;

    @GetMapping
    public ResponseEntity<List<ContaAReceberModel>> buscarContaAReceber() {
        return ResponseEntity.ok(service.buscarTodasContaAReceber());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ContaAReceberModel>> buscarPorId(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity <ContaAReceberModel> cadastrarConta(@Valid @RequestBody ContaAReceberModel conta) {
        return ResponseEntity.ok(service.cadastrar(conta));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity <ContaAReceberModel> alterarConta(@PathVariable @RequestBody ContaAReceberModel conta) {
        return ResponseEntity.ok(service.alterar(conta));
    }

    @DeleteMapping(path = "{id}")
    public void deletarConta(@PathVariable Long id) {
        service.deletar(id);
    }

}

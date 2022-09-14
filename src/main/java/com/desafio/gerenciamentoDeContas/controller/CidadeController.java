package com.desafio.gerenciamentoDeContas.controller;

import com.desafio.gerenciamentoDeContas.model.CidadeModel;
import com.desafio.gerenciamentoDeContas.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cidade")
@Validated
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity<List<CidadeModel>> buscarCidade() {
        return ResponseEntity.ok(service.buscarTodasCidades());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<CidadeModel>> buscarPorId( @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CidadeModel> cadastrarCidade(@Valid @RequestBody CidadeModel cidade) {
        return ResponseEntity.ok(service.cadastrar(cidade));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity <CidadeModel> alterarCidade(@Valid @PathVariable Long id, @RequestBody CidadeModel cidade) {
        return ResponseEntity.ok(service.alterar(cidade));
    }

    @DeleteMapping(path = "/id")
    public void deletarCidade(@PathVariable Long id) {
        service.deletar(id);
    }

}

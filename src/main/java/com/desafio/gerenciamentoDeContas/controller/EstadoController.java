package com.desafio.gerenciamentoDeContas.controller;

import com.desafio.gerenciamentoDeContas.model.EnderecoModel;
import com.desafio.gerenciamentoDeContas.model.EstadoModel;
import com.desafio.gerenciamentoDeContas.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estado")
@Validated
public class EstadoController {

    @Autowired
    private EstadoService service;

    public ResponseEntity<List<EstadoModel>> buscarEstado() {
        return ResponseEntity.ok(service.buscarToodosEstados());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<EstadoModel>> buscarEstadoPorId(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping(path = "/estado")
    public ResponseEntity<EstadoModel> cadastrarEstado(@RequestBody EstadoModel estado) {
        return ResponseEntity.ok(service.cadastrar(estado));
    }

    @PutMapping("/codigoDoEstado")
    public ResponseEntity<EstadoModel> alterarEstado(@RequestBody EstadoModel estado) {
        return ResponseEntity.ok(service.alterar(estado));
    }

    @DeleteMapping("/{id}")
    public void deltarEstado(@Valid @PathVariable Long id) {
        service.deletar(id);

    }

}

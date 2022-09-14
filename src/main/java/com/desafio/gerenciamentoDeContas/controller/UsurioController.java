package com.desafio.gerenciamentoDeContas.controller;


import com.desafio.gerenciamentoDeContas.model.UsuarioModel;
import com.desafio.gerenciamentoDeContas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/ usuario")
@Validated

@RestController
public class UsurioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarUsuario() {
        return ResponseEntity.ok(service.buscarTodosUsuario());
    }

    @GetMapping("/{id}")

    public ResponseEntity<Optional<UsuarioModel>> buscarPorI(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuario) {
        return service.cadastrar(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> alterarUsuario(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.ok(service.alterar(usuario));
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@Valid @PathVariable Long id) {
        service.deletar(id);

    }

}

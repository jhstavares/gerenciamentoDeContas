package com.desafio.gerenciamentoDeContas.controller;

import com.desafio.gerenciamentoDeContas.model.ContasModel;
import com.desafio.gerenciamentoDeContas.model.ResponseModel;
import com.desafio.gerenciamentoDeContas.repository.ContasRepository;
import com.desafio.gerenciamentoDeContas.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContasController {

    @Autowired
    private ContasService contasService;

    @Autowired
    private ContasRepository contasRepository;

    @GetMapping(path = "/contas")
    public ResponseEntity<List<ResponseModel>> buscarTodasAsContas() {
        return ResponseEntity.ok(contasService.buscarTodasAsContas());

    }

    @GetMapping(path = "/contas/{id}")
    public Optional<ContasModel> buscarContasPorId(@PathVariable Long id) {
        return contasService.buscarContasPorId(id);

    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ContasModel> cadastrarContas(@RequestBody ContasModel contas) {
        ContasModel contas1 = contasService.cadastrar(contas);

        return new ResponseEntity<>(contas1, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/contas/{id}")
    public ResponseEntity<ContasModel> atualizarConta(@PathVariable Long id, @RequestBody ContasModel contas) {
        return ResponseEntity.ok(contasService.atualizar(contas));
    }

    @DeleteMapping(path = "/contas/{id}")
    public ResponseEntity deletarConta(@PathVariable Long id) {

        if (!contasRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        contasService.deletar(id);
        return null;
    }


}







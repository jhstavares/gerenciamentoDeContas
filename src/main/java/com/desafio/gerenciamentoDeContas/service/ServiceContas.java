package com.desafio.gerenciamentoDeContas.service;

import com.desafio.gerenciamentoDeContas.enums.StatusEnum;
import com.desafio.gerenciamentoDeContas.model.ModelContas;
import com.desafio.gerenciamentoDeContas.model.ResponseModel;
import com.desafio.gerenciamentoDeContas.repository.RepositoryContas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceContas {
    @Autowired
    private RepositoryContas repositoryContas;

    public List<ResponseModel> buscarTodasAsContas() {
        List<ModelContas> contas = repositoryContas.findAll();
        return contas.stream().map(conta -> new ResponseModel(conta.getId(), conta.getNome(), conta.getValor(), conta.getStatusEnum())).collect(Collectors.toList());
    }


    public Optional<ModelContas> buscarContasPorId(Long IdDaConta) {
        return repositoryContas.findById(IdDaConta);
    }

    public ModelContas cadastrar(ModelContas modelContas) {
        Boolean pagamentoSemAtraso = LocalDate.now().isBefore(modelContas.getDataDeVencimento()) || LocalDate.now().equals(modelContas.getDataDeVencimento());
        if (Boolean.FALSE.equals(pagamentoSemAtraso)) {
            modelContas.setStatusEnum(StatusEnum.VENCIDA);

        } else {
            modelContas.setStatusEnum(StatusEnum.AGUARDANDO);

        }


        return repositoryContas.save(modelContas);
    }

    public ModelContas atualizar(ModelContas modelContas) {
        ModelContas contas = repositoryContas.findById(modelContas.getId()).get();
        if (modelContas.getStatusEnum() == StatusEnum.PAGO){
            contas.setDataDePagamento(LocalDateTime.now(ZoneId.of("UTC-03:00")));
            contas.setStatusEnum(StatusEnum.PAGO);
        }

        return repositoryContas.save(contas);

    }

    public void deletar(Long id) {
        repositoryContas.deleteById(id);


    }
}

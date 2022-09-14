package com.desafio.gerenciamentoDeContas.service;

import com.desafio.gerenciamentoDeContas.enums.StatusEnum;
import com.desafio.gerenciamentoDeContas.model.ContasModel;
import com.desafio.gerenciamentoDeContas.model.ResponseModel;
import com.desafio.gerenciamentoDeContas.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContasService {
    @Autowired
    private ContasRepository contasRepository;

    public List<ResponseModel> buscarTodasAsContas() {
        List<ContasModel> contas = contasRepository.findAll();
        return contas.stream().map(conta -> new ResponseModel(conta.getId(), conta.getNome(), conta.getValor(), conta.getStatusEnum())).collect(Collectors.toList());
    }


    public Optional<ContasModel> buscarContasPorId(Long IdDaConta) {
        return contasRepository.findById(IdDaConta);
    }

    public ContasModel cadastrar(ContasModel contasModel) {
        Boolean pagamentoSemAtraso = LocalDate.now().isBefore(contasModel.getDataDeVencimento()) || LocalDate.now().equals(contasModel.getDataDeVencimento());
        if (Boolean.FALSE.equals(pagamentoSemAtraso)) {
            contasModel.setStatusEnum(StatusEnum.VENCIDA);

        } else {
            contasModel.setStatusEnum(StatusEnum.AGUARDANDO);

        }


        return contasRepository.save(contasModel);
    }

    public ContasModel atualizar(ContasModel contasModel) {
        ContasModel contas = contasRepository.findById(contasModel.getId()).get();
        if (contasModel.getStatusEnum() == StatusEnum.PAGO) {
            contas.setDataDePagamento(LocalDateTime.now(ZoneId.of("UTC-03:00")));
            contas.setStatusEnum(StatusEnum.PAGO);
        }

        return contasRepository.save(contas);

    }

    public void deletar(Long id) {
        contasRepository.deleteById(id);


    }
}

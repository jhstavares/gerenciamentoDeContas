package com.desafio.gerenciamentoDeContas.model.RecebimentoCalculos;

import com.desafio.gerenciamentoDeContas.model.ContaAReceberModel;

import java.math.BigDecimal;

public class EmAtraso implements CalculoRecebimento {

    @Override
    public BigDecimal calculoRecebimento(ContaAReceberModel contaAReceberModel) {
        BigDecimal ad = contaAReceberModel.getValor().multiply(new BigDecimal(String.valueOf(3.5)));
        return contaAReceberModel.getValor();
    }
}

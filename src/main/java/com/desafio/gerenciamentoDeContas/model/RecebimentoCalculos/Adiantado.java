package com.desafio.gerenciamentoDeContas.model.RecebimentoCalculos;

import com.desafio.gerenciamentoDeContas.model.ContaAReceberModel;

import java.math.BigDecimal;

public class Adiantado implements CalculoRecebimento {

    @Override
    public BigDecimal calculoRecebimento(ContaAReceberModel contaAReceberModel) {
        BigDecimal re = contaAReceberModel.getValor().multiply(new BigDecimal(String.valueOf(0.05)));
        return contaAReceberModel.getValor().subtract(re);
    }
}

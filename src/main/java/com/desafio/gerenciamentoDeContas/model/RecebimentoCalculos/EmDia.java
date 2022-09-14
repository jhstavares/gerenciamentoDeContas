package com.desafio.gerenciamentoDeContas.model.RecebimentoCalculos;

import com.desafio.gerenciamentoDeContas.model.ContaAReceberModel;

import java.math.BigDecimal;

public class EmDia implements CalculoRecebimento {


    @Override
    public BigDecimal calculoRecebimento(ContaAReceberModel contaAReceberModel) {
        return contaAReceberModel.getValor();
    }
}

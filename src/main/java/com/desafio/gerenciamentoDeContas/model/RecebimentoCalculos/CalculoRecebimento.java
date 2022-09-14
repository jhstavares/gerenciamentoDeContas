package com.desafio.gerenciamentoDeContas.model.RecebimentoCalculos;

import com.desafio.gerenciamentoDeContas.model.ContaAReceberModel;

import java.math.BigDecimal;

public interface CalculoRecebimento {
    public BigDecimal calculoRecebimento(ContaAReceberModel contaAReceberModel);
}

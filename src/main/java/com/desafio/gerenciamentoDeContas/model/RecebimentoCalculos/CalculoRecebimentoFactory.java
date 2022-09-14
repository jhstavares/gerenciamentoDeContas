package com.desafio.gerenciamentoDeContas.model.RecebimentoCalculos;

import com.desafio.gerenciamentoDeContas.enums.RecebimentoAlugueisStatus;
import com.desafio.gerenciamentoDeContas.enums.TipoRecebimentoEnum;

public class CalculoRecebimentoFactory {
    public CalculoRecebimento getRecebimento(String nomeRecebimento) {
        if (nomeRecebimento.equalsIgnoreCase("Adiantado")) {
            return new Adiantado();
        } else if (nomeRecebimento.equalsIgnoreCase("EnAtraso")) {
            return new EmAtraso();

        } else if (nomeRecebimento.equalsIgnoreCase("EmDia")) {
            return new EmDia();

        } else {
            return null;

        }

    }

}



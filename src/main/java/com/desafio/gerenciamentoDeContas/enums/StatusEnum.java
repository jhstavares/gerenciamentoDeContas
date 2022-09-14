package com.desafio.gerenciamentoDeContas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    AGUARDANDO,
    PAGO,
    VENCIDA
}

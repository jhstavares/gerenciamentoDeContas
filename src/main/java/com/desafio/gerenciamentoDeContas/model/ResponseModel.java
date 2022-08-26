package com.desafio.gerenciamentoDeContas.model;

import com.desafio.gerenciamentoDeContas.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
     private Long id;
     private String nome;
     private double valor;
     private StatusEnum statusEnum;

}

package com.desafio.gerenciamentoDeContas.model;

import com.desafio.gerenciamentoDeContas.enums.StatusEnum;
import com.desafio.gerenciamentoDeContas.enums.TiposEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "gerenciamento_de_contas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private double valor;

    @Column
    private TiposEnum tiposEnum;

    @Column(name = "data_de_vencimento", length = 50, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(name = "data_pagamento")
    private LocalDateTime dataDePagamento;

    @Enumerated(value = EnumType.STRING)
    private StatusEnum statusEnum;




}

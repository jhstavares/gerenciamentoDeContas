package com.desafio.gerenciamentoDeContas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated

public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String logradouro;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String bairro;

    @Column(length = 8, nullable = false)
    @NotEmpty
    private String cep;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoModel estado;

}

package com.desafio.gerenciamentoDeContas.model;

import com.desafio.gerenciamentoDeContas.enums.StatusEnum;
import com.desafio.gerenciamentoDeContas.enums.TiposEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "conta_a_receber")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ContaAReceberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String recebimento;

    @Column(length = 50, nullable = false)
    private BigDecimal valor;

    @Column(name = "data_de_vencimento", length = 50, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(name = "data_recbimento")
    private LocalDateTime dataDeRecebimento;

    @Column
    private TiposEnum tiposEnumRecebido;

    @Enumerated(value = EnumType.STRING)
    private StatusEnum statusEnum;

}

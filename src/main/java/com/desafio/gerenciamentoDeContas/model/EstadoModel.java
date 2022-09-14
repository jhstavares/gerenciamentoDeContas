package com.desafio.gerenciamentoDeContas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated

public class EstadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2, nullable = false)
    @NotEmpty
    private String uf;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String nomeEstado;

    @OneToMany(mappedBy = "Estado", cascade = CascadeType.ALL)
    private List<CidadeModel> cidade = new ArrayList<>();

}

package com.desafio.gerenciamentoDeContas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated

public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String nomeUsuario;

    @Column(name = "data_de_nascimento", length = 50, nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 50, nullable = false)
    @NotEmpty
    @Email
    private String email;

    @Column(length = 11, nullable = false)
    @NotEmpty
    @CPF
    private String cpf;


}

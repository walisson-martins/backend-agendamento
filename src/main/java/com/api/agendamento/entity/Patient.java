package com.api.agendamento.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @Column(name = "Nome", nullable = false)
    private String nome;

    @NotNull(message = "CPF não pode ser nulo")
    @Column(name = "CPF", unique = true, nullable = false)
    private String cpf;

    @NotNull(message = "Email não pode ser nulo")
    @Column(name = "Email", nullable = false)
    private String email;

    @NotNull(message = "Telefone não pode ser nulo")
    @Column(name = "Telefone", nullable = false)
    private String telefone;

    @NotNull(message = "Ativo não pode ser nulo")
    @Column(name = "Ativo", nullable = false)
    private Boolean ativo;

}

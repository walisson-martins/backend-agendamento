package com.api.agendamento.entity;

import java.io.Serializable;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "Nome", nullable = false)
    private Long nome;

    @NonNull
    @Column(name = "CPF", unique = true)
    private String cpf;

    @NonNull
    @Column(name = "Email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "Telefone", nullable = false)
    private String telefone;

    @NonNull
    @Column(name = "Ativo", nullable = false)
    private Boolean ativo;

    public Patient(Long nome, String cpf, String email, String telefone, Boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.ativo = ativo;

    }

}

package com.api.agendamento.entity;

import java.io.Serializable;

import com.api.agendamento.enums.EnumSpecialty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "Nome", nullable = false)
    private String nome;

    @NonNull
    @Column(name = "Especialidade", nullable = false)
    private EnumSpecialty enumEspecialidade;

    @NonNull
    @Column(name = "CRM", nullable = false, unique = true)
    private String crm;

    @NonNull
    @Column(name = "Ativo", nullable = false)
    private Boolean ativo;

}

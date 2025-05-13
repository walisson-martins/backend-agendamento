package com.api.agendamento.entity;

import java.io.Serializable;

import com.api.agendamento.enums.EnumSpecialty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull(message = "Especialidades não pode ser nulo")
    @Column(name = "especialidade", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumSpecialty enumEspecialidade;

    @NotNull(message = "CRM não pode ser nulo")
    @Column(name = "CRM", nullable = false, unique = true)
    private String crm;

    @NotNull(message = "Ativo não pode ser nulo")
    @Column(name = "Ativo", nullable = false)
    private Boolean ativo;

}

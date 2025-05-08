package com.api.agendamento.entity;

import java.io.Serializable;

import com.api.agendamento.enums.EnumSpecialty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private EnumSpecialty enumEspecialidade;
    private String crm;
    private Boolean ativo;

}

package com.api.agendamento.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private Boolean ativo;

    public PatientDTO() {
    }

}

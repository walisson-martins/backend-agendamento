package com.api.agendamento.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Boolean ativo;

}

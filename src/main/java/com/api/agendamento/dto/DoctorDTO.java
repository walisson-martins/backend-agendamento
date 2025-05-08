package com.api.agendamento.dto;

import java.io.Serializable;

import com.api.agendamento.enums.EnumSpecialty;

import lombok.Data;

@Data
public class DoctorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private EnumSpecialty enumEspecialidade;
    private String crm;
    private Boolean ativo;

    public DoctorDTO() {
    }

}

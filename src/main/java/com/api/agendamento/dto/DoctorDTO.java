package com.api.agendamento.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.api.agendamento.enums.EnumSpecialty;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

    @JsonProperty("enumEspecialidade")
    private EnumSpecialty enumEspecialidade;

    private String crm;
    private Boolean ativo = true;

    private LocalDateTime dataHora;

}

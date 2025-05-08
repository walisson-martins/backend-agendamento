package com.api.agendamento.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ApointmentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idPaciente;
    private Long idMedico;
    private Boolean cancelada;

    public ApointmentDTO() {
    }

}

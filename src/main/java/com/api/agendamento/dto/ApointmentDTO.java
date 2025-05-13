package com.api.agendamento.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApointmentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idPaciente;
    private Long idMedico;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;

    private Boolean cancelada;

}

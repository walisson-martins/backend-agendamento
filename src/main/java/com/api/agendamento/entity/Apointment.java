package com.api.agendamento.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Apointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "Identificador Paciente", nullable = false)
    private Long idPaciente;

    @NonNull
    @Column(name = "Identificador Medico", nullable = false)
    private Long idMedico;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @NonNull
    @Column(name = "Data e Hora", nullable = false)
    private LocalDateTime dataHora;

    @NonNull
    @Column(name = "Cancelado", nullable = false)
    private Boolean cancelada;

    public Apointment(Long idPaciente, Long idMedico, LocalDateTime dataHora, Boolean cancelada) {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.dataHora = dataHora;
        this.cancelada = cancelada;
    }

}

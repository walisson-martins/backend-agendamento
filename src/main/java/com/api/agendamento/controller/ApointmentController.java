package com.api.agendamento.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agendamento.dto.ApointmentDTO;
import com.api.agendamento.dto.BaseResponseDTO;
import com.api.agendamento.entity.Apointment;
import com.api.agendamento.services.ApointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/consultas")
@Tag(name = "Consultas", description = "API para agendamento de consultas")
public class ApointmentController {

    private final ApointmentService apointmentService;

    public ApointmentController(ApointmentService apointmentService) {
        this.apointmentService = apointmentService;
    }

    @PostMapping
    @Operation(summary = "Agendar uma nova consulta", description = "Cria um novo agendamento de consulta para um paciente.")
    public ResponseEntity<BaseResponseDTO> salvar(@RequestBody ApointmentDTO apointmentDTO) {
        return ResponseEntity.status(201)
                .body(new BaseResponseDTO("Foi cadastrado com sucesso!", apointmentService.salvar(apointmentDTO)));
    }

    @GetMapping
    @Operation(summary = "Buscar Consulta", description = "Busca a lista de consultas")
    public ResponseEntity<List<ApointmentDTO>> buscar() {
        List<Apointment> list = apointmentService.find();

        List<ApointmentDTO> apointmentDTO = list.stream()
                .map(obj -> {
                    ApointmentDTO dto = new ApointmentDTO();
                    dto.setIdPaciente(obj.getIdPaciente());
                    dto.setIdMedico(obj.getIdMedico());
                    dto.setDataHora(obj.getDataHora());
                    dto.setCancelada(obj.getCancelada());
                    return dto;
                }).collect(Collectors.toUnmodifiableList());

        return ResponseEntity.ok().body(apointmentDTO);
    }

    @PutMapping(value = "/{id}/cancelar")
    @Operation(summary = "Cancelar Consulta", description = "Cancela o agendamento da consulta")
    public ResponseEntity<BaseResponseDTO> cancelar(@PathVariable Long id) {
        String mensagem = apointmentService.cancel(id);
        return ResponseEntity.ok(new BaseResponseDTO("Consulta cancelada com sucesso!", mensagem));
    }
}

package com.api.agendamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agendamento.dto.BaseResponseDTO;
import com.api.agendamento.dto.PatientDTO;
import com.api.agendamento.services.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pacientes")
@Tag(name = "Consultas", description = "API para agendamento de consultas")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar paciente.", description = "Cria um novo paciente")
    public ResponseEntity<BaseResponseDTO> salvar(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.status(201).body(new BaseResponseDTO("Foi cadastrado com sucesso!", patientService.salvar(patientDTO)));
    }
}

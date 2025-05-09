package com.api.agendamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agendamento.dto.BaseResponseDTO;
import com.api.agendamento.dto.DoctorDTO;
import com.api.agendamento.services.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/medicos")
@Tag(name = "Consultas", description = "API para agendamento de consultas")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar médico.", description = "Cria um novo Médico")
    public ResponseEntity<BaseResponseDTO> salvar(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.status(201).body(new BaseResponseDTO("Foi cadastrado com sucesso!", doctorService.salvar(doctorDTO)));
    }

}

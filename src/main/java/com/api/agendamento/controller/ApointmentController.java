package com.api.agendamento.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agendamento.dto.ApointmentDTO;
import com.api.agendamento.dto.BaseResponseDTO;
import com.api.agendamento.entity.Apointment;
import com.api.agendamento.services.ApointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    public ResponseEntity<List<ApointmentDTO>> buscar() {

        List<Apointment> list = apointmentService.find();
        List<ApointmentDTO> apointmentDTO = list.stream()
                .map(obj
                        -> new ApointmentDTO()).collect(Collectors.toUnmodifiableList());

        return ResponseEntity.ok().body(apointmentDTO);
    }
}

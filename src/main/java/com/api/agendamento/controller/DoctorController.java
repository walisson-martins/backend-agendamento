package com.api.agendamento.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agendamento.dto.BaseResponseDTO;
import com.api.agendamento.dto.DoctorDTO;
import com.api.agendamento.entity.Doctor;
import com.api.agendamento.services.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
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
        Doctor doctor = doctorService.fromDto(doctorDTO);

        return ResponseEntity.status(201)
                .body(new BaseResponseDTO("Foi cadastrado com sucesso!", doctorService.salvar(doctor)));
    }

    @GetMapping(value = "/{id}/horarios-disponiveis")
    @Operation(summary = "Buscar horários disponíves no agendamento", description = "Busca a lista de horários disponíveis dos doutores")
    public ResponseEntity<BaseResponseDTO> buscaHourDoctor(@PathVariable Long id) {
        List<DoctorDTO> doctor = doctorService.findDoctorAppointments(id);

        return ResponseEntity.ok().body(new BaseResponseDTO("Horários disponíveis", doctor));
    }

}

package com.api.agendamento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.ApointmentDTO;
import com.api.agendamento.entity.Apointment;
import com.api.agendamento.repository.ApointmentRepository;

@Service
public class ApointmentService {

    @Autowired
    private ApointmentRepository apointmentRepository;

    public String salvar(ApointmentDTO apointmentDTO) {

        // apointmentRepository.save(apointmentDTO);
        return "Consulta realizada com sucesso!";
    }

    public List<Apointment> find() {
        List<Apointment> apointment = apointmentRepository.findAll();
        return apointment;
    }

    public Apointment fromDto(ApointmentDTO apointmentDTO) {
        return new Apointment(apointmentDTO.getIdPaciente(), apointmentDTO.getIdMedico(),
                LocalDateTime.now(), apointmentDTO.getCancelada());
    }
}

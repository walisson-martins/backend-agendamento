package com.api.agendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.ApointmentDTO;
import com.api.agendamento.repository.ApointmentRepository;

@Service
public class ApointmentService {

    @Autowired
    private ApointmentRepository apointmentRepository;

    public void salvar(ApointmentDTO apointmentDTO) {
        // apointmentRepository.save(apointmentDTO);
    }
}

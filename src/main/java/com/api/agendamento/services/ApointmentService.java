package com.api.agendamento.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
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

        if (apointmentDTO.getIdMedico() != null && apointmentDTO.getIdPaciente() != null) {
            Apointment apointment = fromDto(apointmentDTO);
            apointmentRepository.save(apointment);
            return "Informações da consulta foram salvas com sucesso!";
        }

        return "Não Existe paciente e médico ativos no momento";
    }

    public List<Apointment> find() {
        return apointmentRepository.findAll();
    }

    public String cancel(Long id) {
        Apointment apointment = apointmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Consulta não encontrada"));

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime horarioConsulta = apointment.getDataHora();

        if (apointment.getDataHora() == null) {
            throw new IllegalArgumentException("Data da consulta não pode ser nula.");
        }

        if (apointment.getDataHora().isBefore(LocalDateTime.now().plusHours(12))) {
            throw new IllegalStateException("Consulta só pode ser cancelada até 12 horas antes do horário agendado.");
        }

        if (agora.plusHours(12).isAfter(horarioConsulta)) {
            throw new IllegalStateException("Só é possível cancelar uma consulta com pelo menos 12 horas de antecedência.");
        }

        apointment.setCancelada(true);
        apointmentRepository.save(apointment);

        return "Consulta cancelada com sucesso.";
    }

    public Optional<Apointment> findById(Long id) {
        Optional<Apointment> obj = apointmentRepository.findById(id);
        return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(1, "Objeto não encontrado")));
    }

    public Apointment fromDto(ApointmentDTO apointmentDTO) {
        Apointment apointment = new Apointment();

        apointment.setIdPaciente(apointmentDTO.getIdPaciente());
        apointment.setIdMedico(apointmentDTO.getIdMedico());
        apointment.setDataHora(apointmentDTO.getDataHora());
        apointment.setCancelada(apointmentDTO.getCancelada());
        return apointment;
    }
}

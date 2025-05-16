package com.api.agendamento.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.ApointmentDTO;
import com.api.agendamento.entity.Apointment;
import com.api.agendamento.entity.Doctor;
import com.api.agendamento.repository.ApointmentRepository;
import com.api.agendamento.repository.DoctorRepository;

@Service
public class ApointmentService {

    @Autowired
    private ApointmentRepository apointmentRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorRepository doctorRepository;

    public String salvar(ApointmentDTO apointmentDTO) {

        var medico = doctorService.findById(apointmentDTO.getIdMedico());
        var paciente = patientService.findById(apointmentDTO.getIdPaciente());

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime horarioConsulta = apointmentDTO.getDataHora();

        List<Apointment> consultasNoMesmoHorario = apointmentRepository
                .findByDoctorIdAndDataHora(apointmentDTO.getIdMedico(), horarioConsulta);

        if (!consultasNoMesmoHorario.isEmpty()) {
            throw new IllegalStateException("O médico já tem uma consulta marcada no mesmo horário.");
        }

        if (agora.plusHours(24).isAfter(horarioConsulta)) {
            throw new IllegalStateException("Só é possível agendar uma consulta com pelo menos 24 horas de antecedência.");
        }

        if (medico.getAtivo() && paciente.getAtivo()) {
            Apointment apointment = fromDto(apointmentDTO);
            apointmentRepository.save(apointment);
            return "Informações da consulta foram salvas com sucesso!";
        } else {
            throw new IllegalArgumentException("Não Existe paciente e médico ativos no momento");
        }
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
        Doctor doctor = doctorRepository.findById(apointmentDTO.getIdMedico())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        Apointment apointment = new Apointment();
        apointment.setDoctor(doctor);
        apointment.setIdPaciente(apointmentDTO.getIdPaciente());
        apointment.setDataHora(apointmentDTO.getDataHora());
        apointment.setCancelada(apointmentDTO.getCancelada());

        return apointment;

    }
}

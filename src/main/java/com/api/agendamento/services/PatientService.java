package com.api.agendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.PatientDTO;
import com.api.agendamento.entity.Patient;
import com.api.agendamento.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public String salvar(Patient patient) {
        patientRepository.save(patient);

        return "Informações do Paciente foram salvas com sucesso!";
    }

    public Patient fromDto(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setNome(patientDTO.getNome());
        patient.setCpf(patientDTO.getCpf());
        patient.setEmail(patientDTO.getEmail());
        patient.setTelefone(patientDTO.getTelefone());
        patient.setAtivo(patientDTO.getAtivo());
        return patient;
    }

}

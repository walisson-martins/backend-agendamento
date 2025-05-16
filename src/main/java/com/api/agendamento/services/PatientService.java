package com.api.agendamento.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
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

    public PatientDTO findById(Long id) {
        Optional<Patient> obj = patientRepository.findById(id);
        Patient patient = obj.orElseThrow(() -> new ObjectNotFoundException(1, "Objeto não encontrado"));

        PatientDTO dto = new PatientDTO();
        dto.setNome(patient.getNome());
        dto.setCpf(patient.getCpf());
        dto.setEmail(patient.getEmail());
        dto.setTelefone(patient.getTelefone());
        dto.setAtivo(patient.getAtivo());

        return dto;
    }

}

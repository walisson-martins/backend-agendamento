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

    public String salvar(PatientDTO PatientDTO) {
        // PatientRepository.save(PatientDTO);

        return "Consulta realizada com sucesso!";
    }

    public Patient fromDto(PatientDTO patientDTO) {
        return new Patient(patientDTO.getNome(), patientDTO.getCpf(),
                patientDTO.getEmail(), patientDTO.getTelefone(), patientDTO.getAtivo());
    }
}

package com.api.agendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.PatientDTO;
import com.api.agendamento.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void salvar(PatientDTO PatientDTO) {
        // PatientRepository.save(PatientDTO);
    }
}

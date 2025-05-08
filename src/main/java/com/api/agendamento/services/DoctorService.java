package com.api.agendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.DoctorDTO;
import com.api.agendamento.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void salvar(DoctorDTO doctorDTO) {

        // doctorRepository.save(doctorDTO);
    }

}

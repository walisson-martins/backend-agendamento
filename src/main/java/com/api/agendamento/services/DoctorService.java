package com.api.agendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.DoctorDTO;
import com.api.agendamento.entity.Doctor;
import com.api.agendamento.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public String salvar(DoctorDTO doctorDTO) {

        // doctorRepository.save(doctorDTO);
        return "Consulta realizada com sucesso!";
    }

    public Doctor fromDto(DoctorDTO doctorDto) {
        return new Doctor(doctorDto.getNome(), doctorDto.getEnumEspecialidade(), doctorDto.getCrm(), doctorDto.getAtivo());
    }

}

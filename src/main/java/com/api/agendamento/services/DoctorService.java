package com.api.agendamento.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.DoctorDTO;
import com.api.agendamento.entity.Doctor;
import com.api.agendamento.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public String salvar(Doctor doctor) {
        doctorRepository.save(doctor);
        return "Informações do Médico foram salvas com sucesso!";
    }

    public Doctor fromDto(DoctorDTO doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setNome(doctorDto.getNome());
        doctor.setEnumEspecialidade(doctorDto.getEnumEspecialidade());
        doctor.setCrm(doctorDto.getCrm());
        doctor.setAtivo(doctorDto.getAtivo());
        return doctor;
    }

    public Optional<Doctor> findById(Long id) {
        Optional<Doctor> obj = doctorRepository.findById(id);
        return Optional.of(obj.orElseThrow(() -> new ObjectNotFoundException(1, "Objeto não encontrado")));
    }

}

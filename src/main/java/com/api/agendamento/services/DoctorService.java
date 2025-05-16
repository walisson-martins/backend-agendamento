package com.api.agendamento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.agendamento.dto.DoctorDTO;
import com.api.agendamento.entity.Apointment;
import com.api.agendamento.entity.Doctor;
import com.api.agendamento.repository.ApointmentRepository;
import com.api.agendamento.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ApointmentRepository apointmentRepository;

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

    public DoctorDTO findById(Long id) {
        Optional<Doctor> obj = doctorRepository.findById(id);
        Doctor doctor = obj.orElseThrow(() -> new ObjectNotFoundException(1, "Objeto não encontrado"));

        DoctorDTO dto = new DoctorDTO();
        dto.setNome(doctor.getNome());
        dto.setEnumEspecialidade(doctor.getEnumEspecialidade());
        dto.setCrm(doctor.getCrm());
        dto.setAtivo(doctor.getAtivo());

        return dto;
    }

    public List<DoctorDTO> findDoctorAppointments(Long idDoctor) {
        List<Apointment> appointments = apointmentRepository.findByDoctorId(idDoctor);

        if (appointments == null || appointments.isEmpty()) {
            return new ArrayList<>();
        }

        return appointments.stream().map(appointment -> {
            DoctorDTO dto = new DoctorDTO();
            dto.setDataHora(appointment.getDataHora());

            Doctor doctor = appointment.getDoctor();

            if (doctor != null) {
                dto.setNome(doctor.getNome());
                dto.setEnumEspecialidade(doctor.getEnumEspecialidade());
                dto.setCrm(doctor.getCrm());
                dto.setAtivo(doctor.getAtivo());
            }

            return dto;
        }).toList();
    }

}

package com.api.agendamento.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.agendamento.entity.Apointment;

public interface ApointmentRepository extends JpaRepository<Apointment, Long> {

    List<Apointment> findByDoctorIdAndDataHora(Long doctorId, LocalDateTime dataHora);

    List<Apointment> findByDoctorId(Long doctorId);

}

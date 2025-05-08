package com.api.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.agendamento.entity.Apointment;

public interface ApointmentRepository extends JpaRepository<Apointment, Long> {

}

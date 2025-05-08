package com.api.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.agendamento.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

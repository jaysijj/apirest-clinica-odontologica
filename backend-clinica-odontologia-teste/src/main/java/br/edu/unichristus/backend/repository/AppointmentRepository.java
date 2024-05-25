package br.edu.unichristus.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//	  List<Appointment> findById(Long id);
//    List<Appointment> findByPacienteId(Long pacienteId);
//    List<Appointment> findByDentistaId(Long dentistaId);
}

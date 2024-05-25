package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Dentist;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
    Optional<Dentist> findByNome(String nome);
    Optional<Dentist> findById(Long id);
}

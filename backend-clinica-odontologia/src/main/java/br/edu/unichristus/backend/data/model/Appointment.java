package br.edu.unichristus.backend.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_consultas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    @Column(name = "id_dentista", nullable = false)
    private Long idDentista;

    @Column(name = "data_consulta", nullable = false)
    private LocalDateTime dataConsulta;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
}
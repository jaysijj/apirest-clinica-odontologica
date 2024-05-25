package br.edu.unichristus.backend.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentLowDTO {
    private Long id;
    private Long idPaciente;
    private Long idDentista;
    private LocalDateTime dataConsulta;
    private String descricao;
}

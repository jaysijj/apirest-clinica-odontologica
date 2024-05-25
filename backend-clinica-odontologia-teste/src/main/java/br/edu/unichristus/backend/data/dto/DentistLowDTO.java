package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DentistLowDTO {
    private Long id;
    private Long idUsuario;
    private String nome;
    private String especialidade;
    private String telefone;
    private String endereco;
    private String horarioAtendimento;
}

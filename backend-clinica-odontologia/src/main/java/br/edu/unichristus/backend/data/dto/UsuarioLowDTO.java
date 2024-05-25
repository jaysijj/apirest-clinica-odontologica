package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioLowDTO {
    private Long id;
    private String nomeUsuario;
    private String cpf;
    private String email;
    private String papel;
}

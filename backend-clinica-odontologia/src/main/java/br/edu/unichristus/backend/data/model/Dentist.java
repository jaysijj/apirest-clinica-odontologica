package br.edu.unichristus.backend.data.model;

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
@Table(name = "tb_dentistas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dentist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private String nome;

    @Column
    private String especialidade;

    @Column
    private String telefone;

    @Column
    private String endereco;

    @Column(name = "horario_atendimento")
    private String horarioAtendimento;
}

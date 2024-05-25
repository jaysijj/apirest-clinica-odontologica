package br.edu.unichristus.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.AppointmentDTO;
import br.edu.unichristus.backend.data.dto.AppointmentLowDTO;
import br.edu.unichristus.backend.data.model.Appointment;
import br.edu.unichristus.backend.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Operation(summary = "Agendar consulta", description = "Agendar uma nova consulta", tags = "Consultas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Consulta agendada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "404", description = "Consulta não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public AppointmentLowDTO save(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.save(appointmentDTO);
    }

    @Operation(summary = "Editar consulta", description = "Editar uma nova consulta", tags = "Consultas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Edição concluida com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping
    public AppointmentLowDTO update(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.save(appointmentDTO);
    }

    @Operation(summary = "Listar todas as consulta", description = "Listas todas as consulta", tags = "Consultas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Listagem realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/all")
    public List<AppointmentLowDTO> listAll() {
        return appointmentService.listAll();
    }

    @Operation(summary = "Deletar consulta por ID", description = "Deletar consulta por ID", tags = "Consultas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Consulta deletada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @Operation(summary = "Lista consulta por ID", description = "Lista consulta por ID", tags = "Consultas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Consulta encontrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public Appointment findById(@RequestParam(required = true)  Long id) {
        return appointmentService.findById(id);
    }
}

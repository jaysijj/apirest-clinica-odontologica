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

import br.edu.unichristus.backend.data.dto.DentistDTO;
import br.edu.unichristus.backend.data.dto.DentistLowDTO;
import br.edu.unichristus.backend.data.model.Dentist;
import br.edu.unichristus.backend.service.DentistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/dentists")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @Operation(summary = "Cadastrar dentista", description = "Adiciona um novo dentista", tags = "Dentista")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Dentista cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Não escreveu o nome"),
        @ApiResponse(responseCode = "409", description = "Não digitou o nome"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public DentistLowDTO save(@RequestBody DentistDTO dentistDTO) {
        return dentistService.save(dentistDTO);
    }

    @Operation(summary = "Editar dentista", description = "Editar um dentista", 
    		tags = "Dentista")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Dentista editado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "404", description = "Dentista não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping
    public DentistLowDTO update(@RequestBody DentistDTO dentistDTO) {
        return dentistService.edit(dentistDTO);
    }

    @Operation(summary = "Listar todos os dentista", description = "Listar todos os dentista", tags = "Dentista")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Listagem realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/all")
    public List<DentistLowDTO> listAll() {
        return dentistService.listAll();
    }

    @Operation(summary = "Deletar dentista", description = "Deletar um dentista", tags = "Dentista")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Dentista deletado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dentistService.delete(id);
    }

    @Operation(summary = "Listar um dentista", description = "Lista um dentista pelo ID", tags = "Dentista")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Dentista encontrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public Dentist findById(@RequestParam(required = true) Long id) {
        return dentistService.findById(id);
    }
}
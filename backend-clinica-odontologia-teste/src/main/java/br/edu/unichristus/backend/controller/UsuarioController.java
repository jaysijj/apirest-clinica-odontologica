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

import br.edu.unichristus.backend.data.dto.UsuarioDTO;
import br.edu.unichristus.backend.data.dto.UsuarioLowDTO;
import br.edu.unichristus.backend.data.model.Usuario;
import br.edu.unichristus.backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Cadastrar usuário", description = "Adiciona um novo usuário", 
    		tags = "Usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Limite de caractere excedido"),
        @ApiResponse(responseCode = "409", description = "CPF já existe."),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping
    public UsuarioLowDTO save(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @Operation(summary = "Editar usuário", description = "Editar um usuário", 
    		tags = "Usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário editado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping
    public UsuarioLowDTO update(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @Operation(summary = "Listar todos os usuários", description = "Listar todos os usuários", 
    		tags = "Usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Listado todos com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/all")
    public List<UsuarioLowDTO> listAll() {
        return usuarioService.listAll();
    }

    @Operation(summary = "Deletar usuário", description = "Deleta um usuário", 
    		tags = "Usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    @Operation(summary = "Listar um usuário", description = "Listar um usuário", 
    		tags = "Usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuário listado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public Usuario findById(@RequestParam(required = true) Long id) {
        return usuarioService.findById(id);
    }
}
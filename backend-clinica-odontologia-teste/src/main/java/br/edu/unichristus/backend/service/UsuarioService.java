package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.UsuarioDTO;
import br.edu.unichristus.backend.data.dto.UsuarioLowDTO;
import br.edu.unichristus.backend.data.model.Usuario;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioLowDTO save(UsuarioDTO usuarioDTO) {
        var usuarioModel = DozerConverter.parseObject(usuarioDTO, Usuario.class);
        if (usuarioModel.getNomeUsuario().length() > 50) {
            throw new CommonsException(
                HttpStatus.BAD_REQUEST,
                "br.edu.unichristus.backend.service.usuario.badrequest.exception",
                "Nome ultrapassou 50 caracteres"
            );
        }
        var usuarioFind = usuarioRepository.findByCpf(usuarioModel.getCpf());
        if (!usuarioFind.isEmpty()) {
            throw new CommonsException(
                HttpStatus.CONFLICT,
                "br.edu.unichristus.backend.service.usuario.conflict.exception",
                "CPF já existe."
            );
        }
        var usuarioSaved = usuarioRepository.save(usuarioModel);
        return DozerConverter.parseObject(usuarioSaved, UsuarioLowDTO.class);
    }

    public List<UsuarioLowDTO> listAll() {
        var listUsers = usuarioRepository.findAll();
        if (listUsers.isEmpty()) {
            throw new CommonsException(
                HttpStatus.NOT_FOUND,
                "br.edu.unichristus.backend.service.usuario.notfound.exception",
                "Nenhum usuário encontrado."
            );
        }
        return DozerConverter.parseListObjects(listUsers, UsuarioLowDTO.class);
    }

    public void delete(Long id) {
        findById(id);
        if ( findById(id) == null) {
            throw new CommonsException(
                HttpStatus.NOT_FOUND,
                "com.example.clinica.service.usuario.notfound.exception",
                "O usuário com a ID informada não foi encontrado."
            );
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario findById(Long id) {
        var usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new CommonsException(
                HttpStatus.NOT_FOUND,
                "com.example.clinica.service.usuario.notfound.exception",
                "O usuário com a ID informada não foi encontrado."
            );
        }
        return usuario.get();
    }
}

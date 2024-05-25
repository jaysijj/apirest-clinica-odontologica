package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.DentistDTO;
import br.edu.unichristus.backend.data.dto.DentistLowDTO;
import br.edu.unichristus.backend.data.model.Dentist;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.DentistRepository;

@Service
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public DentistLowDTO save(DentistDTO dentistDTO) {
        var dentistModel = DozerConverter.parseObject(dentistDTO, Dentist.class);
        var dentistFind = dentistRepository.findByNome(dentistModel.getNome());
        if (dentistModel.getNome().isEmpty()) {
            throw new CommonsException(
                HttpStatus.CONFLICT,
                "com.example.clinica.service.dentist.conflict.exception",
                "Por favor, informe um nome para o dentista"
            );
        }
        if (dentistFind.isPresent()) {
            throw new CommonsException(
                HttpStatus.BAD_REQUEST,
                "com.example.clinica.service.dentist.badrequest.exception",
                "Já existe um dentista com esse nome."
            );
        }
        var dentistSaved = dentistRepository.save(dentistModel);
        return DozerConverter.parseObject(dentistSaved, DentistLowDTO.class);
    }
    
    public DentistLowDTO edit(DentistDTO dentistDTO) {
        var dentistModel = DozerConverter.parseObject(dentistDTO, Dentist.class);
        var dentistFindNome = dentistRepository.findByNome(dentistModel.getNome());
        var dentistFindId = dentistRepository.findById(dentistModel.getId());
        if (!dentistFindId.isPresent()) {
            throw new CommonsException(
                HttpStatus.NOT_FOUND,
                "com.example.clinica.service.dentist.notfound.exception",
                "Id do usuário não encontrado, digite um id válido."
            );
        }
        if (dentistModel.getNome().isEmpty()) {
            throw new CommonsException(
                HttpStatus.CONFLICT,
                "com.example.clinica.service.dentist.conflict.exception",
                "Por favor, informe um nome para o dentista"
            );
        }
        if (dentistFindNome.isPresent()) {
            throw new CommonsException(
                HttpStatus.BAD_REQUEST,
                "com.example.clinica.service.dentist.badrequest.exception",
                "Já existe um dentista com esse nome."
            );
        }

        var dentistSaved = dentistRepository.save(dentistModel);
        return DozerConverter.parseObject(dentistSaved, DentistLowDTO.class);
    }

    public List<DentistLowDTO> listAll() {
        var listDentists = dentistRepository.findAll();
        if (listDentists.isEmpty()) {
            throw new CommonsException(
                HttpStatus.NOT_FOUND,
                "br.edu.unichristus.backend.service.dentist.notfound.exception",
                "Nenhum usuário encontrado."
            );
        }
        return DozerConverter.parseListObjects(listDentists, DentistLowDTO.class);
    }

    public void delete(Long id) {
        findById(id);
        if (findById(id) instanceof Dentist) {
        	dentistRepository.deleteById(id);
            throw new CommonsException(
                    HttpStatus.OK,
                    "com.example.clinica.service.dentist.ok.exception",
                    "Usuário deletado com sucesso"
                );
        }
    }

    public Dentist findById(Long id) {
        var dentist = dentistRepository.findById(id);
        if (dentist.isEmpty()) {
            throw new CommonsException(
                HttpStatus.NOT_FOUND,
                "com.example.clinica.service.dentist.notfound.exception",
                "O dentista com a ID informada não foi encontrado."
            );
        }
        return dentist.get();
    }
}

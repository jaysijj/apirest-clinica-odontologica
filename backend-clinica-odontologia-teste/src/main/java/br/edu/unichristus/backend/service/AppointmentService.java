package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.AppointmentDTO;
import br.edu.unichristus.backend.data.dto.AppointmentLowDTO;
import br.edu.unichristus.backend.data.model.Appointment;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentLowDTO save(AppointmentDTO appointmentDTO) {
        var appointmentModel = DozerConverter.parseObject(appointmentDTO, Appointment.class);
  	    var appointmentSaved = appointmentRepository.save(appointmentModel);
        var FindId = appointmentRepository.findById(appointmentModel.getId());
        if (FindId.isEmpty()) {
            throw new CommonsException(
                HttpStatus.CONFLICT,
                "com.example.clinica.service.usuario.conflict.exception",
                "O CPF informado já existe!"
            );
        }

        return DozerConverter.parseObject(appointmentSaved, AppointmentLowDTO.class);
    }

    public List<AppointmentLowDTO> listAll() {
        var listAppointments = appointmentRepository.findAll();
        return DozerConverter.parseListObjects(listAppointments, AppointmentLowDTO.class);
    }

    public void delete(Long id) {
        findById(id);
        appointmentRepository.deleteById(id);
    }

    public Appointment findById(Long id) {
        var appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty()) {
            throw new CommonsException(
                HttpStatus.NOT_FOUND,
                "com.example.clinica.service.appointment.notfound.exception",
                "A consulta com a ID informada não foi encontrada."
            );
        }
        return appointment.get();
    }
}
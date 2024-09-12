package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.HorariosConsultaRepository;
import com.example.demo.repository.PacienteRepository;
//import com.cine.demo.model.Pelicula;
import com.example.demo.model.HorariosConsulta;
import com.example.demo.model.Paciente;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;
    
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente) {
       if(pacienteRepository.existsById(id)){
            paciente.setId(id.intValue());
            return pacienteRepository.save(paciente);
       }else{
            throw new IllegalArgumentException("Paciente no encontrado");
       }
               
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        if (paciente.getNombre() == null || paciente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }

        if (paciente.getApellido() == null || paciente.getApellido().isEmpty()) {
            throw new IllegalArgumentException("apellido vacío");
        }

        if (paciente.getTelefono() == null || paciente.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("telefono vacío");
        }
       
    
        return pacienteRepository.save(paciente);
    }

    

    
    
}
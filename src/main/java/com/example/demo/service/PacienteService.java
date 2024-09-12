package com.example.demo.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.example.demo.model.HorariosConsulta;
import com.example.demo.model.Medico;
import com.example.demo.model.Paciente;

@Service
public interface PacienteService {
    List<Paciente> getAllPacientes();
    Paciente updatePaciente(Long id, Paciente paciente);
    void deletePaciente(Long id);
    Paciente createPaciente(Paciente paciente);

}

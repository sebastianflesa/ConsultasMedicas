package com.example.demo.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Paciente;
import com.example.demo.service.PacienteService;


@RestController
@RequestMapping("/pacientes")
public class PacientesController {
    @Autowired
    private PacienteService pacienteService;
    @GetMapping
    public List<Paciente> getAllPacientes(){
        return pacienteService.getAllPacientes();
    }

    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.updatePaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }

    @PostMapping 
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteService.createPaciente(paciente);
    }

    


}

/*


@RequestMapping("/pacientes")
public class PacientesController {
    @Autowired
    private PacienteService pacienteService;
    
    public List<Paciente> getAllPacientes(){
        return pacienteService.getAllPacientes();
    }


}
*/

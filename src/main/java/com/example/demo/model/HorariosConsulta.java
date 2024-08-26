package com.example.demo.model;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HorariosConsulta {
    //Esta clase tiene todas las horas tomadas por los pacientes en un dia
    private int id;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_termino;
    private Medico medico;
    private Paciente paciente;
    
}

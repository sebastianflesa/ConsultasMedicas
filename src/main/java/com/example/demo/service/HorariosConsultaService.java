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
public class HorariosConsultaService {
    private List<HorariosConsulta> horariosConsultas = new ArrayList<>();
    

    public HorariosConsultaService() {
        horariosConsultas.add(
            new HorariosConsulta(
                1,
                LocalDateTime.of(2024, 8, 26, 10, 0),
                LocalDateTime.of(2024, 8, 26, 10, 59),
                new Medico(1, "Juan", "Topo", "Medico General"),
                new Paciente(1, "Pedro ", "Gonzalez", "+56955452152")
            )
        );

        horariosConsultas.add(
            new HorariosConsulta(
                2,
                LocalDateTime.of(2024, 8, 26, 11, 0),
                LocalDateTime.of(2024, 8, 26, 11, 59),
                new Medico(2, "Juan", "Topo", "Medico General"),
                new Paciente(1, "Sebastian ", "Farias", "+56955452152")
            )
        );

        horariosConsultas.add(
            new HorariosConsulta(
                3,
                LocalDateTime.of(2024, 8, 26, 12, 0),
                LocalDateTime.of(2024, 8, 26, 12, 59),
                new Medico(2, "Juan", "Topo", "Medico General"),
                new Paciente(1, "Pedro ", "Pedrope", "+56955452152")
            )
        );
        
    }
    
    public List<HorariosConsulta> getHorasTomadas() {
        return horariosConsultas;
    }

    public List<LocalDateTime> getDisponibleFecha(String fecha) {
        //Fecha en formato yyyy-MM-dd
        ArrayList<LocalDateTime> horasDelDia = new ArrayList<>();
        LocalDate fechaConvertida = LocalDate.parse(fecha);
        LocalDateTime fechaHora = fechaConvertida.atStartOfDay();
        
        //Horas de atencion de 8 a 20, todas las horas posibles de un dia
        for (int i = 8; i < 21; i++) {
            horasDelDia.add(
                LocalDateTime.of(fechaHora.getYear(), 
                fechaHora.getMonthValue(), 
                fechaHora.getDayOfMonth(), 
                i, 
            0));
        }

        ArrayList<LocalDateTime> result = eliminarHorasNoDisponibles(horasDelDia, horariosConsultas);
        System.out.println("Horas disponibles: " + result);
        return horasDelDia;
    }

    public ArrayList<LocalDateTime> eliminarHorasNoDisponibles(ArrayList<LocalDateTime> horasDisponibles, List<HorariosConsulta> horariosConsultas) {
        Set<LocalDateTime> horasOcupadas = new HashSet<>();
        for (HorariosConsulta horario : horariosConsultas) {
            horasOcupadas.add(horario.getFecha_inicio());
        }
        horasDisponibles.removeAll(horasOcupadas);

        return horasDisponibles;
    }
    

}

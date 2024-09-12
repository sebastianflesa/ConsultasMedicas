package com.example.demo.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.HorariosConsultaService;
import com.example.demo.model.HorariosConsulta;



@RestController

@RequestMapping("/horarios")
public class HorariosConsultaController {
    @Autowired
    private HorariosConsultaService horariosService;
    
    @GetMapping("tomadas")
    public List<HorariosConsulta> getAllHorasTomadas(){
        return horariosService.getAllHorasTomadas();
    }

    @GetMapping("disponible/{fecha}")
    public ResponseEntity<?> getDisponibleFecha(@PathVariable String fecha) {
        List<LocalDateTime>  fechas = horariosService.getDisponibleFecha(fecha);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("fechas_disponibles", fechas);
        map.put("status", "200");
        return ResponseEntity.status(200).body(map);
        
    }

    /*
    @Autowired
    private HorariosConsultaService horariosService;

    @GetMapping("tomadas")
    public List<HorariosConsulta> getHorasTomadas() {
        return horariosService.getHorasTomadas();
    }

    @GetMapping("disponible/{fecha}")
    public ResponseEntity<?> getDisponibleFecha(@PathVariable String fecha) {
        ArrayList<LocalDateTime>  fechas = (ArrayList<LocalDateTime>) horariosService.getDisponibleFecha(fecha);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("fechas_disponibles", fechas);
        map.put("status", "200");
        return ResponseEntity.status(200).body(map);
    }
    */


    

}

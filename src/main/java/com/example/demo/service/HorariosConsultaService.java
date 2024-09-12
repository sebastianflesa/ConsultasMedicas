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
public interface HorariosConsultaService {
    List<HorariosConsulta> getAllHorasTomadas();
    List<LocalDateTime> getDisponibleFecha(String fecha);
    /*
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaById(Long id);
    Pelicula createPelicula(Pelicula pelicula);
    Pelicula updatePelicula(Long id, Pelicula pelicula);
    void deletePelicula(Long id);
    */
}

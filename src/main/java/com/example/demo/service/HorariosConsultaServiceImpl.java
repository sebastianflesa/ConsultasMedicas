package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.HorariosConsultaRepository;
//import com.cine.demo.model.Pelicula;
import com.example.demo.model.HorariosConsulta;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;

@Service
public class HorariosConsultaServiceImpl implements HorariosConsultaService{
    @Autowired
    private HorariosConsultaRepository horasTomadasRepository;
    
    public List<HorariosConsulta> getAllHorasTomadas() {
        return horasTomadasRepository.findAll();
    }

    public List<LocalDateTime> getDisponibleFecha(String fecha) {
        //Fecha en formato yyyy-MM-dd
        List<HorariosConsulta> horariosConsultas = horasTomadasRepository.findAll();
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

        eliminarHorasNoDisponibles(horasDelDia, horariosConsultas);
        return horasDelDia;
    }

    public void eliminarHorasNoDisponibles(ArrayList<LocalDateTime> horasDelDia, List<HorariosConsulta> horariosConsultas) {
        Set<LocalDateTime> horasOcupadas = new HashSet<>();
        for (HorariosConsulta horario : horariosConsultas) {
            horasOcupadas.add(horario.getFecha_inicio());
        }
        horasDelDia.removeAll(horasOcupadas);
    }

    /*
    public List<Object> getDisponibleFecha(String fecha) {
        return horasTomadasRepository.findAll();
    }
    */
    
    
    /*/
    @Override
    public Optional<Pelicula> getPeliculaById(Long id) {
        if (peliculaRepository.findById(id).isEmpty()) {
            return Optional.ofNullable(new Pelicula());
        }
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula updatePelicula(Long id, Pelicula pelicula) {
       if(peliculaRepository.existsById(id)){
            pelicula.setId(id.intValue());
            return peliculaRepository.save(pelicula);
       }else{
            throw new IllegalArgumentException("Pelicula no encontrada");
       }
               
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        if (pelicula.getTitulo() == null || pelicula.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("titulo vacio");
        }
        if (pelicula.getDirector() == null || pelicula.getDirector().isEmpty()) {
            throw new IllegalArgumentException("director vacío");
        }
        if (pelicula.getAno() == 0) {
            throw new IllegalArgumentException("anho vacío");
        }
        if (pelicula.getGenero() == null || pelicula.getGenero().isEmpty()) {
            throw new IllegalArgumentException("genero vacío");
        }

        if (pelicula.getSinopsis() == null || pelicula.getSinopsis().isEmpty()) {
            throw new IllegalArgumentException("sinopsis vacío");
        }
       
    
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void deletePelicula(Long id) {
        peliculaRepository.deleteById(id);
    }




    
    */


    
    
    
}
package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.HorariosConsulta;

public interface HorariosConsultaRepository extends JpaRepository<HorariosConsulta, Long>{
    
}
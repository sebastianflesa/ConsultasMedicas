package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;

}

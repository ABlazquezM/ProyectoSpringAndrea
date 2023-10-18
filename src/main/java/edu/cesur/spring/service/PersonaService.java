package edu.cesur.spring.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import edu.cesur.spring.model.Persona;

public interface PersonaService {

	public ArrayList<Persona> muestraPersonas();

	public Persona crearPersona(Persona p);

	public Persona modificarPersona(Persona p);

	public ResponseEntity<?> eliminarPersona(int id);

}

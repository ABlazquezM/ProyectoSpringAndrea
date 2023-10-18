package edu.cesur.spring.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import edu.cesur.spring.model.Persona;
@Service
public class PersonaServiceImpl implements PersonaService {
	
	ArrayList<Persona> listaPersonas = new ArrayList<>(Arrays.asList(new Persona(1,"María",29,"rrr111"),
			new Persona(2,"Carlos",69,"jjj222"),new Persona(3,"Irene",33,"lll333"),new Persona(4,"Felix",40,"ooo444")));
/*
	ArrayList<Persona> listaPersonas = new ArrayList<>(Arrays.asList(new Persona(1,"María",29),
			new Persona(2,"Carlos",69),new Persona(3,"Irene",33),new Persona(4,"Felix",40)));
*/	
	
	public ArrayList<Persona> muestraPersonas() {
		return listaPersonas;
	}

	
	public Persona crearPersona(Persona p) {
		listaPersonas.add(p);
		return p;
	}

	
	public Persona modificarPersona(Persona p) {
	
	for(Persona per : listaPersonas) {
		if (per.getId()==p.getId()) {
			per.setEdad(p.getEdad());
			per.setNombre(p.getNombre());
			return p;
		}
	} return null;
	
		
	}

	
	public ResponseEntity<?> eliminarPersona(@PathVariable int id) {
		for(Persona per : new ArrayList<>(listaPersonas)) {
			if(per.getId()==id) {
				listaPersonas.remove(per);
				return ResponseEntity.noContent().build();
			
			}
		}
		return ResponseEntity.notFound().build();
	}

}

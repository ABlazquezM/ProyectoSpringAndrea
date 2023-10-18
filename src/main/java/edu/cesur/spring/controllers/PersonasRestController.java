package edu.cesur.spring.controllers;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.spring.model.Persona;
import edu.cesur.spring.service.PersonaService;
import edu.cesur.spring.validators.OnCreate;
import edu.cesur.spring.validators.OnUpdate;

@RestController
@RequestMapping ("/personas")
public class PersonasRestController {

	
	PersonaService personaService; //Declaración de la interfaz
	
	
	
	//Constructor 
	public PersonasRestController(PersonaService personaService) {
		this.personaService = personaService;
	}

	
	@GetMapping
	public ResponseEntity<ArrayList<?>> listaDePersonas(){
		ArrayList<Persona> personas = personaService.muestraPersonas();
		return ResponseEntity.ok(personas);
	}
	
	
	@PostMapping
	public ResponseEntity<Persona> crearPersona(@RequestBody @Validated(OnCreate.class) Persona p) {
		personaService.crearPersona(p);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(p.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> modificarPersona(@RequestBody @Validated(OnUpdate.class) Persona p) {
		personaService.modificarPersona(p);
		return ResponseEntity.ok(p);
	}
	
	@DeleteMapping("/{id}")
	public void borrarPersona(@PathVariable int id) {
		personaService.eliminarPersona(id);	}
}


package edu.cesur.spring.controllers;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.spring.exceptions.CocheNotFoundException;
import edu.cesur.spring.exceptions.InvalidCocheException;
import edu.cesur.spring.model.Coche;
import edu.cesur.spring.model.Persona;
import edu.cesur.spring.service.CocheService;

@RestController
@RequestMapping("/coches") // Ruta de la url
public class CocheRestController {

	CocheService cocheService;

	public CocheRestController(CocheService cocheService) {
		this.cocheService = cocheService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Coche> getCocheById(@PathVariable @Validated Integer id) {

		if (cocheService.getCocheByID(id) != null) {

			Coche coche = cocheService.getCocheByID(id);
			return ResponseEntity.ok(coche);
		}

		throw new CocheNotFoundException("No se ha encontrado un coche con el id: " + id);

	}
	
	@GetMapping
	public ResponseEntity<ArrayList<?>> listaCoches(){
		ArrayList<Coche> c = cocheService.muestraCoches();
		return ResponseEntity.ok(c);
	}

	
	@PostMapping
	public ResponseEntity<Coche> agregarCoche(@RequestBody @Validated Coche c) {

		if (cocheService.agregarcoche(c) != null) {
			

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId())
					.toUri();

			return ResponseEntity.created(location).build();
		}

		throw new InvalidCocheException("Lo sentimos, ya no aceptamos mas coches");

	}

}

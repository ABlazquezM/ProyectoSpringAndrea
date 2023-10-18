package edu.cesur.spring.model;

import edu.cesur.spring.validators.CodePersona;
import edu.cesur.spring.validators.OnCreate;
import edu.cesur.spring.validators.OnUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	@NotNull(groups = {OnCreate.class,OnUpdate.class}) //Los datos no pueden ser nulos
	int id;
	
	@NotBlank (groups = {OnCreate.class,OnUpdate.class})
	String nombre;
	
	@NotNull (groups = OnCreate.class)
	int edad;
	
	@CodePersona(groups = OnCreate.class)
	String codePersona;

//	String codigoPersona;
//	public Persona(int id, String nombre, int edad,String codigoPersona) {
//		this.id = id;
//		this.nombre = nombre;
//		this.edad = edad;
//		this.codigoPersona= codigoPersona;
//	}
//
//	public String getCodigoPersona() {
//		return codigoPersona;
//	}
//
//	public void setCodigoPersona(String codigoPersona) {
//		this.codigoPersona = codigoPersona;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public int getEdad() {
//		return edad;
//	}
//
//	public void setEdad(int edad) {
//		this.edad = edad;
//	}

}

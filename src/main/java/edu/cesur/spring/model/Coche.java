package edu.cesur.spring.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coche {

	@NotNull
	Integer id;
	@NotBlank
	String marca;
	@NotBlank
	String modelo;
}

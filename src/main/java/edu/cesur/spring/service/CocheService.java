package edu.cesur.spring.service;

import java.util.ArrayList;

import edu.cesur.spring.model.Coche;

public interface CocheService {
	
	Coche getCocheByID(Integer id);
	
	Coche agregarcoche(Coche c);
	
	ArrayList<Coche> muestraCoches();

}

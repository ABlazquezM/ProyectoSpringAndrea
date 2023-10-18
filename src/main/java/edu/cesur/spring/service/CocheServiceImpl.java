package edu.cesur.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.cesur.spring.model.Coche;

@Service
public class CocheServiceImpl implements CocheService {
	
	ArrayList<Coche> listaCoches = new ArrayList<>();

	@Override
	public Coche getCocheByID(Integer id) {

		if (id > 0) {
			return new Coche(id, "Audi", "A5");
		}

		return null;
	}

	@Override
	public Coche agregarcoche(Coche c) {
		if(listaCoches.size()<3) {
			listaCoches.add(c);
			return c;
		}
		return null;
	}

	@Override
	public ArrayList<Coche> muestraCoches() {

		return listaCoches;
		
	}

}

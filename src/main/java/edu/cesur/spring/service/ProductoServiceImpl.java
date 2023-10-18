package edu.cesur.spring.service;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.cesur.spring.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	ArrayList<Producto> listaProductos = new ArrayList<>(Arrays.asList(new Producto(1L,"Lapicero",0.85),
			new Producto(2L,"Bolígrafo",1.68),new Producto(3L,"Estuche",15),new Producto(4L,"Agenda",20.90)));

	@Override
	public ArrayList<Producto> muestraProductos() {
		return listaProductos;
	}

	@Override
	public Producto crearProducto(Producto p) {
		listaProductos.add(p);
		return p;
	}

	@Override
	public Producto modificarProducto(Producto p) {
		for (Producto pro : listaProductos) {
			if (pro.getId()==p.getId()) {
				pro.setName(p.getName());
				pro.setPrice(p.getPrice());
				return p;
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<?> eliminarProducto(int id) {
		for (Producto pro : listaProductos) {
			if (pro.getId()==id) {
				listaProductos.remove(pro);
			}
		}
			return null;
	}

}

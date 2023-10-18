package edu.cesur.spring.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import edu.cesur.spring.model.Producto;

public interface ProductoService {

	public ArrayList<Producto> muestraProductos();

	public Producto crearProducto(Producto p);

	public Producto modificarProducto(Producto p);

	public ResponseEntity<?> eliminarProducto(int id);

}

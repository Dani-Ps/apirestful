package com.api.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.productos.entities.Producto;
import com.api.productos.model.ProductoModel;
import com.api.productos.service.ProductoService;

@RestController
@RequestMapping("/v1")
public class ProductoController {

	
	@Autowired
	@Qualifier("ProductoService")
	ProductoService productoService;


	// METODO POST
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@PostMapping("/producto")
	public boolean agregarProducto(@RequestBody @Validated Producto producto) {
		return productoService.agregarProducto(producto);
	}

	// MÉTODO PUT
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@PutMapping("/producto")
	public boolean editarProducto(@RequestBody @Validated Producto producto) {
		return productoService.editarProducto(producto);

	}

	// MÉTODO DELETE
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@DeleteMapping("/producto/{id}")
	public boolean eliminarProducto(@PathVariable("id") int id) {
		return productoService.eliminarProducto(id);

	}

	// MÉTODO GET
	@GetMapping("/productos")
	public List<ProductoModel> listadoProductos(Pageable pageable) {
		return productoService.listadoProductos(pageable);
	}


	// ---GET---
	@GetMapping("/productos/id/{id}")
	public ProductoModel getById(@PathVariable("id") int id) {

		return productoService.findById(id);
	}

	// ---GET---
	@GetMapping("/productos/codigo/{codigo}")
	public List<ProductoModel> getByCodigo(@PathVariable("codigo") String codigo) {

		return productoService.findByCodigo(codigo);
	}

	// ---GET---
	@GetMapping("/productos/nombre/{nombre}")
	public List<ProductoModel> getByNombre(@PathVariable("nombre") String nombre) {

		return productoService.findByNombre(nombre);
	}

	// ---GET---
	@GetMapping("/productos/precio/{precio}")
	public List<ProductoModel> getByPrecio(@PathVariable("precio") float precio) {

		return productoService.findByPrecio(precio);
	}

	
}

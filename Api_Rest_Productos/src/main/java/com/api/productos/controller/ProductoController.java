package com.api.productos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.productos.entities.Producto;
import com.api.productos.service.implementation.ProductoServiceImpl;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Qualifier("productoService")
	@Autowired
	ProductoServiceImpl productoService;

	// METODO POST
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@PostMapping("/")
	public ResponseEntity<Page<Producto>> listarTodosLosProductos(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		logger.info("ProductoController :: listarTodosLosProductos");
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(productoService.listarTodosLosProducto(pageable), HttpStatus.OK);
	}

	// Leer un producto por ID
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	public Producto getProductpById(@PathVariable Long id) {
		return productoService.obtenerProductoPorId(id);
	}

	// CRUD endpoints, accesibles solo por ROLE_ADMIN
	// Crear un nuevo producto
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Producto createProduct(@RequestBody Producto producto) {
		return productoService.agregarProducto(producto);
	}

	// Actualizar un producto
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Producto updateProduct(@PathVariable Long id, @RequestBody Producto detalleProducto) {
		return productoService.actualizarProducto(id, detalleProducto);
	}

	// Eliminar un producto
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteProduct(@PathVariable Long id) {
		productoService.eliminarProducto(id);
	}

}
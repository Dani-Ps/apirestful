package com.api.productos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.api.productos.service.interfaces.ProductServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Qualifier("productoService")
	private final ProductServiceI productoService;

	public ProductoController(ProductServiceI productoService) {
		this.productoService = productoService;
	}

	@PreAuthorize("hasRole('ADMINISTRADOR')")
	@GetMapping
	@Operation(summary = "Obtener todos los Productos", description = "Devuelve una lista paginada de productos")
	@ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente")
	@ApiResponse(responseCode = "204", description = "No hay productos disponibles")
	@ApiResponse(responseCode = "400", description = "Parámetros de solicitud incorrectos")
	public ResponseEntity<Page<Producto>> listarTodosLosProductos(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		logger.info("ProductoController :: listarTodosLosProductos");
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(productoService.listarTodosLosProducto(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	@Operation(summary = "Obtener un Producto por ID", description = "Devuelve un Producto específico por su ID")
	@ApiResponse(responseCode = "200", description = "Producto encontrado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class)) })
	@ApiResponse(responseCode = "404", description = "Producto no encontrado")
	public Producto getProductpById(@PathVariable Long id) {
		return productoService.obtenerProductoPorId(id);
	}

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Operation(summary = "Crear un nuevo producto", description = "Crea un nuevo producto y lo guarda en la base de datos")
	@ApiResponse(responseCode = "201", description = "Producto creado con éxito")
	@ApiResponse(responseCode = "400", description = "Datos proporcionados para el nuevo producto son inválidos")
	public Producto createProduct(@Valid @RequestBody Producto producto) {
		return productoService.agregarProducto(producto);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Operation(summary = "Actualizar un producto", description = "Actualiza los detalles de un producto existente")
	@ApiResponse(responseCode = "200", description = "producto actualizado correctamente")
	@ApiResponse(responseCode = "404", description = "producto no encontrado para actualizar")
	public Producto updateProduct(@Valid @PathVariable Long id, @RequestBody Producto detalleProducto) {
		return productoService.actualizarProducto(id, detalleProducto);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Operation(summary = "Borrar un producto", description = "Elimina un producto existente por su ID")
	@ApiResponse(responseCode = "204", description = "producto eliminado correctamente")
	@ApiResponse(responseCode = "404", description = "producto no encontrado para eliminar")
	public void deleteProduct(@PathVariable Long id) {
		productoService.eliminarProducto(id);
	}

}
package com.api.productos.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.productos.entities.Producto;

public interface ProductServiceI {

	Producto agregarProducto(Producto producto);

	Page<Producto> listarTodosLosProducto(Pageable pageable);

	Producto obtenerProductoPorId(Long id);

	Producto actualizarProducto(Long id, Producto producto);

	void eliminarProducto(Long id);

}

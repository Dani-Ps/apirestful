package com.api.productos.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.api.productos.dtos.ProductoDTO;
import com.api.productos.entities.Producto;

public interface ProductServiceI {
	boolean agregarProducto(Producto producto);
    boolean editarProducto(Producto producto);
    boolean eliminarProducto(int id);
    List<ProductoDTO> listadoProductos(Pageable pageable);
    ProductoDTO findById(int id);
    List<ProductoDTO> findByCodigo(String codigo);
    List<ProductoDTO> findByNombre(String nombre);
    List<ProductoDTO> findByPrecio(float precio);
}

package com.api.productos.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.productos.entities.Producto;
import com.api.productos.error.exception.ProductoNotFoundException;
import com.api.productos.repositories.interfaces.ProductoRepository;
import com.api.productos.service.interfaces.ProductServiceI;

@Service("productoService")
public class ProductoServiceImpl implements ProductServiceI {

	@Qualifier("productoRepository")
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto agregarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Page<Producto> listarTodosLosProducto(Pageable pageable) {
		return productoRepository.findAll(pageable);
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado"));
	}

	@Override
	public Producto actualizarProducto(Long id, Producto producto) {
		Producto p = obtenerProductoPorId(id);
		p.setCodigo(producto.getCodigo());
		p.setNombre(producto.getNombre());
		p.setPrecio(producto.getPrecio());

		return productoRepository.save(p);
	}

	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}

}

package com.api.productos.repositories.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.productos.entities.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public abstract Producto findById(int id);

	public abstract List<Producto> findByCodigo(String codigo);

	public abstract List<Producto> findByNombre(String nombre);

	public abstract List<Producto> findByPrecio(Double precio);

	public abstract Page<Producto> findAll(Pageable pageable);

}

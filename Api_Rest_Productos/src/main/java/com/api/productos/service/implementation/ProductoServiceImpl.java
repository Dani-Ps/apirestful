package com.api.productos.service.implementation;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.productos.converters.ProductoConverter;
import com.api.productos.dtos.ProductoDTO;
import com.api.productos.entities.Producto;
import com.api.productos.repositories.interfaces.ProductoRepository;
import com.api.productos.service.interfaces.ProductServiceI;

@Service("ProductoService")
public class ProductoServiceImpl implements ProductServiceI{

	@Autowired
	@Qualifier("I_ProductoRepository")
	private ProductoRepository iProductoRepository;

	@Autowired
	@Qualifier("ProductoConverter")
	private ProductoConverter productoConvertidor;

	// LOGS DE ERROR
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(ProductoServiceImpl.class);

	// INSERT
    @Override
	public boolean agregarProducto(Producto producto) {

		try {
			if (producto == null) {
				logger.error("ERROR AGREGAR_PRODUCTO: EL PRODUCTO ES NULO!");
				return false;
			}

			else {
				iProductoRepository.save(producto);
				return true;

			}

		} catch (Exception e) {
			logger.error("ERROR AGREGAR_PRODUCTO: EL PRODUCTO NO SE HA GUARDADO!");
			return false;

		}
	}

	// UPDATE
    @Override
	public boolean editarProducto(Producto producto) {

		try {

			if ((producto == null) || (producto.getId() == 0)) {
				logger.error("ERROR EDITAR_PRODUCTO:  EL PRODUCTO ES NULO O EL ID ES 0!");
				return false;

			}

			else {
				iProductoRepository.save(producto);
				return true;

			}

		} catch (Exception e) {
			logger.error("ERROR EDITAR_PRODUCTO: EL PRODUCTO NO SE HA EDITADO!");
			return false;

		}
	}

	// DELETE
    @Override
	public boolean eliminarProducto(int id) {

		try {

			if ((id == 0)) {
				logger.error("ERROR ELIMINAR_PRODUCTO: EL ID DEL PRODUCTO ES 0!");
				return false;
			}

			else {

				Producto idProducto = iProductoRepository.findById(id);

				iProductoRepository.delete(idProducto);

				return true;
			}

		} catch (Exception e) {
			logger.error("ERROR ELIMINAR_PRODUCTO: EL PRODUCTO NO SE HA ELIMINADO!");
			return false;

		}
	}

	// LISTA DE PRODUCTOS
    @Override
	public List<ProductoDTO> listadoProductos(Pageable pageable) {

		return productoConvertidor.convertirListaProducto(iProductoRepository.findAll(pageable).getContent());

	}

	// PRODUCTO POR ID | VALOR UNICO
    @Override
	public ProductoDTO findById(int id) {

		return new ProductoDTO(iProductoRepository.findById(id));

	}

	// PRODUCTO POR CODIGO
    @Override
	public List<ProductoDTO> findByCodigo(String codigo) {

		return productoConvertidor.convertirListaProducto(iProductoRepository.findByCodigo(codigo));
	}

	// LISTA DE PRODUCTOS POR NOMBRE
    @Override
	public List<ProductoDTO> findByNombre(String nombre) {

		return productoConvertidor.convertirListaProducto(iProductoRepository.findByNombre(nombre));

	}

	// LISTA DE PRODUCTOS POR PRECIO
    @Override
	public List<ProductoDTO> findByPrecio(float precio) {

		return productoConvertidor.convertirListaProducto(iProductoRepository.findByPrecio(precio));

	}

}

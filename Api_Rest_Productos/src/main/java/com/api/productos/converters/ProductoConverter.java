package com.api.productos.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.productos.dtos.ProductoDTO;
import com.api.productos.entities.Producto;

@Component("ProductoConverter")
public class ProductoConverter {

	public List<ProductoDTO> convertirListaProducto(List<Producto> list) {

		List<ProductoDTO> listaModeloProductos = new ArrayList<>();

		list.forEach(objetoProducto -> listaModeloProductos.add(new ProductoDTO(objetoProducto)));

		return listaModeloProductos;

	}

}

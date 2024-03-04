package com.api.productos.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.productos.entities.Producto;
import com.api.productos.model.ProductoModel;

@Component("ProductoConverter")
public class ProductoConverter {
	
	
	
	
	public List<ProductoModel> convertirListaProducto(List<Producto> list){
		
		List<ProductoModel> listaModeloProductos = new ArrayList<>();
	
		
		list.forEach(objetoProducto -> listaModeloProductos.add(new ProductoModel(objetoProducto)));
		
		return listaModeloProductos;
	
	}
	

	


}

package com.api.productos.Api_Rest_Productos;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.api.productos.controller.ProductoController;
import com.api.productos.entities.Producto;
import com.api.productos.service.interfaces.ProductServiceI;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductServiceI productService;

	@Test
	public void testListarTodosLosProductos() throws Exception {
		when(productService.listarTodosLosProducto(any())).thenReturn(Page.empty());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/productos/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetProductpById() throws Exception {
		Long productId = 1L;
		Producto producto = new Producto();
		producto.setId(productId);
		when(productService.obtenerProductoPorId(productId)).thenReturn(producto);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/v1/productos/{id}", productId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testCreateProduct() throws Exception {
		Producto producto = new Producto();
		when(productService.agregarProducto(any())).thenReturn(producto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/productos/add").contentType(MediaType.APPLICATION_JSON)
				.content("{}")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testUpdateProduct() throws Exception {
		Long productId = 1L;
		Producto producto = new Producto();
		producto.setId(productId);
		when(productService.actualizarProducto(eq(productId), any())).thenReturn(producto);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/productos/{id}", productId)
				.contentType(MediaType.APPLICATION_JSON).content("{}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testDeleteProduct() throws Exception {
		Long productId = 1L;
		doNothing().when(productService).eliminarProducto(productId);
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/productos/{id}", productId)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}

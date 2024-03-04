package com.api.productos.dtos;

import com.api.productos.entities.Producto;

public class ProductoDTO {

	private int id;

	private String codigo;

	private String nombre;

	private float precio;

	public ProductoDTO() {
	}

	public ProductoDTO(String codigo, String nombre, float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public ProductoDTO(int id, String codigo, String nombre, float precio) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	/*
	 * @version 1.0
	 * 
	 * Instancia de la clase-entidad Producto
	 * 
	 * @param producto
	 */
	public ProductoDTO(Producto producto) {
		this.id = producto.getId();
		this.nombre = producto.getNombre();
		this.codigo = producto.getCodigo();
		this.precio = producto.getPrecio();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}

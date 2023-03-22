package com.artek.fooddelivery.catalogos.tienda;

import java.util.List;

import com.artek.fooddelivery.catalogos.productos.ProductoModel;


public class TiendaModel {
	
	private Long id;

	private String nombre;

	private String tipo;

	private List<ProductoModel> producto;

	private boolean habilitado;
	
	public TiendaModel() {
		super();
	}

	public TiendaModel(Long id, String nombre, String tipo, List<ProductoModel> producto, boolean habilitado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.producto = producto;
		this.habilitado = habilitado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<ProductoModel> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoModel> producto) {
		this.producto = producto;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
}

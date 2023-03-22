package com.artek.fooddelivery.catalogos.productos;

import java.io.Serializable;
import java.util.List;

import com.artek.fooddelivery.catalogos.pedidos.PedidoModel;
import com.artek.fooddelivery.catalogos.tienda.TiendaEntity;


public class ProductoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String nombre;

	private String tipo;
	
	private double precio;
	
	private List<TiendaEntity> tienda;

	private boolean habilitado;
	
	private List<PedidoModel> pedido;
	
	
	public ProductoModel() {
		super();
	}


	public ProductoModel(Long id, String nombre, String tipo, double precio, List<TiendaEntity> tienda,
			boolean habilitado, List<PedidoModel> pedido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.tienda = tienda;
		this.habilitado = habilitado;
		this.pedido = pedido;
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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public List<TiendaEntity> getTienda() {
		return tienda;
	}


	public void setTienda(List<TiendaEntity> tienda) {
		this.tienda = tienda;
	}


	public boolean isHabilitado() {
		return habilitado;
	}


	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}


	public List<PedidoModel> getPedido() {
		return pedido;
	}


	public void setPedido(List<PedidoModel> pedido) {
		this.pedido = pedido;
	}

	
	
	
}

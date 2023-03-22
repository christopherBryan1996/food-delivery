package com.artek.fooddelivery.catalogos.pedidos;

import java.io.Serializable;
import java.util.List;

import com.artek.fooddelivery.catalogos.productos.ProductoModel;
import com.artek.fooddelivery.catalogos.usuarios.UsuarioModel;


public class PedidoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String solicitud;
	
	private TypePago typoPago;
	
	private boolean habilitado;
	
	private UsuarioModel usuario;
	
	private List<ProductoModel> producto;

	public PedidoModel() {
		super();
	}

	public PedidoModel(Long id, String solicitud, TypePago typoPago, boolean habilitado, UsuarioModel usuario,
			List<ProductoModel> producto) {
		super();
		this.id = id;
		this.solicitud = solicitud;
		this.typoPago = typoPago;
		this.habilitado = habilitado;
		this.usuario = usuario;
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public TypePago getTypoPago() {
		return typoPago;
	}

	public void setTypoPago(TypePago typoPago) {
		this.typoPago = typoPago;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public List<ProductoModel> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoModel> producto) {
		this.producto = producto;
	}
	
	
}

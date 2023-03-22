package com.artek.fooddelivery.catalogos.tienda;

import java.io.Serializable;
import java.util.List;

import com.artek.fooddelivery.catalogos.productos.ProductoEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tienda")
public class TiendaEntity implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tipo")
	private String tipo;
	
	@ManyToMany(mappedBy = "tienda")
	private List<ProductoEntity> producto;
	
	@Column(name = "habilitado")
	private boolean habilitado;
	
	
	public TiendaEntity() {
		super();
	}

	

	public TiendaEntity(Long id, String nombre, String tipo, List<ProductoEntity> producto, boolean habilitado) {
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



	public List<ProductoEntity> getProducto() {
		return producto;
	}



	public void setProducto(List<ProductoEntity> producto) {
		this.producto = producto;
	}



	public boolean isHabilitado() {
		return habilitado;
	}



	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
}

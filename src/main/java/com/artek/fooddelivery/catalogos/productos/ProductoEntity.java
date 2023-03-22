package com.artek.fooddelivery.catalogos.productos;

import java.io.Serializable;
import java.util.List;

import com.artek.fooddelivery.catalogos.pedidos.PedidoEntity;
import com.artek.fooddelivery.catalogos.tienda.TiendaEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class ProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 25)
	private String nombre;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "precio")
	private double precio;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "producto_tienda",
            joinColumns = {@JoinColumn(name = "producto_id")},
            inverseJoinColumns = {@JoinColumn(name = "tienda_id")}
    )
	private List<TiendaEntity> tienda;

	@Column(name = "habilitado")
	private boolean habilitado;
	
	@ManyToMany(mappedBy = "producto")
	private List<PedidoEntity> pedido;
	
	public ProductoEntity() {
		super();
	}

	public ProductoEntity(Long id, String nombre, String tipo, double precio, List<TiendaEntity> tienda,
			boolean habilitado, List<PedidoEntity> pedido) {
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

	public List<PedidoEntity> getPedido() {
		return pedido;
	}

	public void setPedido(List<PedidoEntity> pedido) {
		this.pedido = pedido;
	}
	
}

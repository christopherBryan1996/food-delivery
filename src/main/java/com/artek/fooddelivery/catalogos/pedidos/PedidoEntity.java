package com.artek.fooddelivery.catalogos.pedidos;

import java.io.Serializable;
import java.util.List;

import com.artek.fooddelivery.catalogos.productos.ProductoEntity;
import com.artek.fooddelivery.catalogos.usuarios.UsuarioEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class PedidoEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="solicitud")
	private String solicitud;
	
	@Column(name="tipo_pago")
	private TypePago typoPago;
	
	@Column(name = "habilitado")
	private boolean habilitado;
	
	@ManyToOne()
	@JoinColumn(name="usuario_id")
	private UsuarioEntity usuario;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "pedido_producto",
            joinColumns = {@JoinColumn(name = "pedido_id")},
            inverseJoinColumns = {@JoinColumn(name = "producto_id")}
    )
	private List<ProductoEntity> producto;
	
	public PedidoEntity() {
		super();
	}

	public PedidoEntity(Long id, String solicitud, TypePago typoPago, boolean habilitado, UsuarioEntity usuario,
			List<ProductoEntity> producto) {
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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<ProductoEntity> getProducto() {
		return producto;
	}

	public void setProducto(List<ProductoEntity> producto) {
		this.producto = producto;
	}

	
}

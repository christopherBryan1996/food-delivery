package com.artek.fooddelivery.catalogos.usuarios;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import com.artek.fooddelivery.catalogos.pedidos.PedidoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 25)
	private String nombre;

	@Column(name = "paterno", length = 25)
	private String paterno;

	@Column(name = "materno", length = 25)
	private String materno;

	@Column(name = "tipo")
	private TypeUser tipo;

	@Column(name = "nombre_usuario", unique = true, length = 25)
	private String nombreUsuario;

	@Column(name = "password",  length = 25)
	private String password;

	@Column(name = "habilitado")
	private boolean habilitado;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<PedidoEntity> pedido;
	
	public UsuarioEntity() {
		super();
	}
	
	

	public UsuarioEntity(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}



	public UsuarioEntity(Long id, String nombre, String paterno, String materno, TypeUser tipo, String nombreUsuario,
			String password, boolean habilitado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.tipo = tipo;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
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

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public TypeUser getTipo() {
		return tipo;
	}

	public void setTipo(TypeUser tipo) {
		this.tipo = tipo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
}

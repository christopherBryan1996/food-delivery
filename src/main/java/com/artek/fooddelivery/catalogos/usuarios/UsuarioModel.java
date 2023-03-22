package com.artek.fooddelivery.catalogos.usuarios;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UsuarioModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String nombre;
	
	private String paterno;

	private String materno;

	private TypeUser tipo;
	
	private String nombreUsuario;

	private String password;
	
	private boolean habilitado;
	
	public UsuarioModel() {
		super();
	}

	
	public UsuarioModel(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public UsuarioModel(Long id, String nombre, String materno, TypeUser tipo, String nombreUsuario, String password,
			boolean habilitado) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	
	
	
}

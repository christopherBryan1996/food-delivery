package com.artek.fooddelivery.catalogos.usuarios;

public interface UsuarioService {
	public UsuarioEntity create(UsuarioEntity usuarioEntity);
	public UsuarioEntity update(UsuarioEntity usuarioEntity);
	public UsuarioEntity view(Long id);
	public boolean enable(Long id, boolean enable);
	public boolean sesion(String password,String username);
	public boolean existsByNombreUsuario(String nombreUsuario);
	public UsuarioEntity findByNombreUsuario(String nombreUsuario);
}

package com.artek.fooddelivery.catalogos.usuarios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UsuarioEntity create(UsuarioEntity usuarioEntity) {
		return usuarioRepository.save(usuarioEntity);
	}

	@Override
	public UsuarioEntity update(UsuarioEntity usuarioEntity) {
		return usuarioRepository.save(usuarioEntity);
	}

	@Override
	public UsuarioEntity view(Long id) {
		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
		
		if(!usuarioEntity.isPresent()) {
			throw new EntityNotFoundException("Registro no encontrado");
		}
		
		return usuarioEntity.get();
	}


	@Override
	public boolean sesion(String password, String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	@Override
	public boolean enable(Long id, boolean enable) {
		
		usuarioRepository.enableById(id, enable);
		
		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
		
		return usuarioEntity.get().isHabilitado();
	}

	@Override
	public UsuarioEntity findByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}

}

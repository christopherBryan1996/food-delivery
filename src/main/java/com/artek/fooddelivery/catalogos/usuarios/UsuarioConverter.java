package com.artek.fooddelivery.catalogos.usuarios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {
	
	public UsuarioModel usuarioEntityToUsuarioModel(UsuarioEntity usuarioEntity, List<String> relations) {
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setId(usuarioEntity.getId());
		usuarioModel.setNombre(usuarioEntity.getNombre());
		usuarioModel.setPaterno(usuarioEntity.getPaterno());
		usuarioModel.setMaterno(usuarioEntity.getMaterno());
		usuarioModel.setTipo(usuarioEntity.getTipo());
		usuarioModel.setNombreUsuario(usuarioEntity.getNombreUsuario());
		usuarioModel.setPassword(usuarioEntity.getPassword());
		usuarioModel.setHabilitado(usuarioEntity.isHabilitado());
		return usuarioModel;
	}
	
	public UsuarioEntity usuarioModelToUsuarioEntity(UsuarioModel usuarioModel, List<String> relations) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setId(usuarioModel.getId());
		usuarioEntity.setNombre(usuarioModel.getNombre());
		usuarioEntity.setPaterno(usuarioModel.getPaterno());
		usuarioEntity.setMaterno(usuarioModel.getMaterno());
		usuarioEntity.setTipo(usuarioModel.getTipo());
		usuarioEntity.setNombreUsuario(usuarioModel.getNombreUsuario());
		usuarioEntity.setPassword(usuarioModel.getPassword());
		usuarioEntity.setHabilitado(usuarioModel.isHabilitado());
		return usuarioEntity;
	}
	
	public List<UsuarioModel> usuarioEntityToUsuarioModel(List<UsuarioEntity> usuarioEntityList, List<String> relations) {
		List<UsuarioModel> models = new ArrayList<>();
		for(UsuarioEntity usuarioEntity : usuarioEntityList) {
			models.add(this.usuarioEntityToUsuarioModel(usuarioEntity, relations));
		}
		return models;
	}
	
	public List<UsuarioEntity> usuarioModelToUsuarioEntity(List<UsuarioModel> usuarioModelList, List<String> relations) {
		List<UsuarioEntity> models = new ArrayList<>();
		for(UsuarioModel usuarioModel: usuarioModelList) {
			models.add(this.usuarioModelToUsuarioEntity(usuarioModel, relations));
		}
		return models;
	}
}

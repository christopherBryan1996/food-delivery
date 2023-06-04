package com.artek.fooddelivery.catalogos.tienda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artek.fooddelivery.catalogos.productos.ProductoConverter;

@Component
public class TiendaConverter {
	@Autowired
	private ProductoConverter productoConverter;

	public TiendaEntity tiendaModelToTiendaEntity(TiendaModel tiendaModel, List<String> relations) {
		TiendaEntity tiendaEntity = new TiendaEntity();
		tiendaEntity.setId(tiendaModel.getId());
		tiendaEntity.setNombre(tiendaModel.getNombre());
		tiendaEntity.setTipo(tiendaModel.getTipo());
		tiendaEntity.setHabilitado(tiendaModel.isHabilitado());
		tiendaEntity.setProducto(productoConverter.productoModelToProductoEntity(tiendaModel.getProducto()));

		return tiendaEntity;
	}

	public TiendaModel tiendaEntityToTiendaModel(TiendaEntity tiendaEntity, List<String> relations) {
		TiendaModel tiendaModel = new TiendaModel();
		tiendaModel.setId(tiendaEntity.getId());
		tiendaModel.setNombre(tiendaEntity.getNombre());
		tiendaModel.setTipo(tiendaEntity.getTipo());
		tiendaModel.setHabilitado(tiendaEntity.isHabilitado());

		return tiendaModel;
	}

	public List<TiendaEntity> tiendaModelToTiendaEntity(List<TiendaModel> tiendaModelList, List<String> relations) {

		List<TiendaEntity> models = new ArrayList<>();

		for (TiendaModel tiendaModel : tiendaModelList) {
			models.add(this.tiendaModelToTiendaEntity(tiendaModel, relations));
		}

		return models;
	}

	public List<TiendaModel> tiendaEntityToTiendaModel(List<TiendaEntity> tiendaEntityList, List<String> relations) {
		List<TiendaModel> models = new ArrayList<>();

		for (TiendaEntity tiendaEntity : tiendaEntityList) {
			models.add(this.tiendaEntityToTiendaModel(tiendaEntity, relations));
		}

		return models;
	}
}

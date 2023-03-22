package com.artek.fooddelivery.catalogos.productos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class ProductoConverter {


	public ProductoEntity productoModelToProductoEntity(ProductoModel productoModel, List<String> relations) {

		ProductoEntity productoEntity = new ProductoEntity();

		productoEntity.setId(productoModel.getId());
		productoEntity.setNombre(productoModel.getNombre());
		productoEntity.setTipo(productoModel.getTipo());
		productoEntity.setPrecio(productoModel.getPrecio());
		productoEntity.setHabilitado(productoModel.isHabilitado());

		if (relations.contains("tienda")) {

		}
		

		return productoEntity;
	}

	public ProductoModel productEntityToProductoModel(ProductoEntity productEntity, List<String> relations) {

		ProductoModel productoModel = new ProductoModel();

		productoModel.setId(productEntity.getId());
		productoModel.setNombre(productEntity.getNombre());
		productoModel.setTipo(productEntity.getTipo());
		productoModel.setPrecio(productEntity.getPrecio());
		productoModel.setHabilitado(productEntity.isHabilitado());

		if (relations.contains("tienda")) {

		}
		

		return productoModel;
	}
	
	public List<ProductoEntity> productoModelToProductoEntity(List<ProductoModel> productoModelList, List<String> relations) {

		List<ProductoEntity> models = new ArrayList<>();
		
		for(ProductoModel productoModel : productoModelList) {
			models.add(this.productoModelToProductoEntity(productoModel, relations));
		}
		
		return models;
	}
	
	public List<ProductoModel> productEntityToProductoModel(List<ProductoEntity> productEntityList, List<String> relations) {

		List<ProductoModel> models = new ArrayList<>();
		
		for(ProductoEntity productoEntity : productEntityList) {
			models.add(this.productEntityToProductoModel(productoEntity, relations));
		}
		
		return models;
	}
}

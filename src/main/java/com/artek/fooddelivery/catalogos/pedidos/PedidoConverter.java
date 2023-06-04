package com.artek.fooddelivery.catalogos.pedidos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artek.fooddelivery.catalogos.productos.ProductoConverter;
import com.artek.fooddelivery.catalogos.usuarios.UsuarioConverter;

@Component
public class PedidoConverter {

	@Autowired
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	private ProductoConverter productoConverter;

	public PedidoEntity pedidoModelToPedidoEntity(PedidoModel pedidoModel) {

		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setId(pedidoModel.getId());
		pedidoEntity.setSolicitud(pedidoModel.getSolicitud());
		pedidoEntity.setTypoPago(pedidoModel.getTypoPago());
		pedidoEntity.setHabilitado(pedidoModel.isHabilitado());
		pedidoEntity.setUsuario(
				usuarioConverter.usuarioModelToUsuarioEntity(pedidoModel.getUsuario(), Arrays.asList()));
		pedidoEntity.setProducto(productoConverter.productoModelToProductoEntity(pedidoModel.getProducto()));
		
		return pedidoEntity;
	}

	public PedidoModel pedidoEntityToPedidoModel(PedidoEntity pedidoEntity) {

		PedidoModel pedidoModel = new PedidoModel();
		pedidoModel.setId(pedidoEntity.getId());
		pedidoModel.setSolicitud(pedidoEntity.getSolicitud());
		pedidoModel.setTypoPago(pedidoEntity.getTypoPago());
		pedidoModel.setHabilitado(pedidoEntity.isHabilitado());
		pedidoModel.setUsuario(
				usuarioConverter.usuarioEntityToUsuarioModel(pedidoEntity.getUsuario(), Arrays.asList()));
		pedidoModel.setProducto(productoConverter.productEntityToProductoModel(pedidoEntity.getProducto()));
		return pedidoModel;
	}

	public List<PedidoEntity> pedidoModelToPedidoEntity(List<PedidoModel> pedidoModelList) {

		List<PedidoEntity> models = new ArrayList<>();

		for (PedidoModel pedidoModel : pedidoModelList) {
			models.add(this.pedidoModelToPedidoEntity(pedidoModel));
		}

		return models;
	}

	public List<PedidoModel> pedidoEntityToPedidoModel(List<PedidoEntity> pedidoEntityList) {

		List<PedidoModel> models = new ArrayList<>();

		for (PedidoEntity pedidoEntity: pedidoEntityList) {
			models.add(this.pedidoEntityToPedidoModel(pedidoEntity));
		}

		return models;
	}
}

package com.artek.fooddelivery.catalogos.pedidos;

import java.util.List;

public interface PedidoService {
	public PedidoEntity create(PedidoEntity pedidoEntity);
	public PedidoEntity update(PedidoEntity pedidoEntity);
	public PedidoEntity view(Long id);
	public List<PedidoEntity> list();
	public boolean enable(Long id, boolean enable);
	public List<PedidoEntity> findByIdUsuario(Long id);
}

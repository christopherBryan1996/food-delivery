package com.artek.fooddelivery.catalogos.tienda;

import java.util.List;


public interface TiendaService {
	public TiendaEntity create(TiendaEntity tiendaEntity);
	public TiendaEntity update(TiendaEntity tiendaEntity);
	public TiendaEntity view(Long id);
	public List<TiendaEntity> list();
	public boolean enable(Long id, boolean enable);
}

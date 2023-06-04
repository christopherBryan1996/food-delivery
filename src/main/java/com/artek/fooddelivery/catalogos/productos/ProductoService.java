package com.artek.fooddelivery.catalogos.productos;

import java.util.List;


public interface ProductoService {
	public ProductoEntity create(ProductoEntity productoEntity);
	public ProductoEntity update(ProductoEntity productoEntity);
	public ProductoEntity view(Long id);
	public List<ProductoEntity> list();
	public boolean enable(Long id, boolean enable);
}

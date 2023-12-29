package com.artek.fooddelivery.catalogos.productos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ProductoEntity create(ProductoEntity productoEntity) {
		return productoRepository.save(productoEntity);
	}

	@Override
	public ProductoEntity update(ProductoEntity productoEntity) {
		return productoRepository.save(productoEntity);
	}

	@Override
	public ProductoEntity view(Long id) {
		Optional<ProductoEntity> productoEntity = productoRepository.findById(id);
		
		if(!productoEntity.isPresent()) {
			throw new EntityNotFoundException("Registro no encontrado");
		}
		
		return productoEntity.get();
	}

	@Override
	public List<ProductoEntity> list() {
		return productoRepository.findAll();
	}

	@Override
	public boolean enable(Long id, boolean enable) {
		return false;
	}

}

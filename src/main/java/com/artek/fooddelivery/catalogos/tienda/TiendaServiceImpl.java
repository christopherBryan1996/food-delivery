package com.artek.fooddelivery.catalogos.tienda;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	private TiendaRepository tiendaRepository;

	@Override
	public TiendaEntity create(TiendaEntity tiendaEntity) {
		return tiendaRepository.save(tiendaEntity);
	}

	@Override
	public TiendaEntity update(TiendaEntity tiendaEntity) {
		return tiendaRepository.save(tiendaEntity);
	}

	@Override
	public TiendaEntity view(Long id) {
		Optional<TiendaEntity> tiendaEntity = tiendaRepository.findById(id);

		if (!tiendaEntity.isPresent()) {
			throw new EntityNotFoundException("Registro no encontrado");
		}

		return tiendaEntity.get();
	}

	@Override
	public List<TiendaEntity> list() {
		return tiendaRepository.findAll();
	}

	@Override
	public boolean enable(Long id, boolean enable) {
		tiendaRepository.enableById(id, enable);

		Optional<TiendaEntity> tiendaEntity = tiendaRepository.findById(id);

		return tiendaEntity.get().isHabilitado();
	}

}

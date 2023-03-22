package com.artek.fooddelivery.catalogos.pedidos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoServiceImp implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public PedidoEntity create(PedidoEntity pedidoEntity) {
		return pedidoRepository.save(pedidoEntity);
	}

	@Override
	public PedidoEntity update(PedidoEntity pedidoEntity) {
		return pedidoRepository.save(pedidoEntity);
	}

	@Override
	public PedidoEntity view(Long id) {
		Optional<PedidoEntity > pedidoEntity = pedidoRepository.findById(id);

		if (!pedidoEntity.isPresent()) {
			throw new EntityNotFoundException("Registro no encontrado");
		}

		return pedidoEntity.get();
	}

	@Override
	public List<PedidoEntity> list() {
		return pedidoRepository.findAll();
	}

	@Override
	public boolean enable(Long id, boolean enable) {
		pedidoRepository.enableById(id, enable);
		
		Optional<PedidoEntity > pedidoEntity = pedidoRepository.findById(id);
		
		return pedidoEntity.get().isHabilitado();
	}

	@Override
	public List<PedidoEntity> findByIdUsuario(Long id) {
		return pedidoRepository.findByIdUsuario(id);
	}

}

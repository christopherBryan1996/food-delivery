package com.artek.fooddelivery.catalogos.pedidos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{

	@Transactional
	@Modifying
	@Query("UPDATE PedidoEntity u set u.habilitado =:enable WHERE u.id = :id")
	int enableById(Long id, boolean enable);
	
	@Query("SELECT p FROM PedidoEntity p WHERE p.usuario.id = :id")
	List<PedidoEntity> findByIdUsuario(Long id);
}

package com.artek.fooddelivery.catalogos.tienda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface TiendaRepository extends JpaRepository<TiendaEntity, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE TiendaEntity u set u.habilitado =:enable WHERE u.id = :id")
	int enableById(Long id, boolean enable);
	
}

package com.artek.fooddelivery.catalogos.productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {


	@Transactional
	@Modifying
	@Query("UPDATE ProductoEntity p set p.habilitado =:enable WHERE p.id = :id")
	int enableById(Long id, boolean enable);

}

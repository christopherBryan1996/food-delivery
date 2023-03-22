package com.artek.fooddelivery.catalogos.usuarios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
	public boolean existsByNombreUsuario(String nombreUsuario);
	
	@Transactional
	@Modifying
	@Query("UPDATE UsuarioEntity u set u.habilitado =:enable WHERE u.id = :id")
	int enableById(Long id, boolean enable);
	
	public UsuarioEntity findByNombreUsuario(String nombreUsuario);
}

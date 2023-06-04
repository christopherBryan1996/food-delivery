package com.artek.fooddelivery.catalogos.tienda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = { "*" })
@RequestMapping("/api")
@RestController
public class TiendaRestController {
	
	@Autowired
	private TiendaService tiendaService;

	@Autowired
	private TiendaConverter tiendaConverter;

	@PostMapping("/tiendas")
	public ResponseEntity<Object> create(@RequestBody TiendaModel tiendaModel) {

		TiendaEntity tiendaEntity = tiendaConverter.tiendaModelToTiendaEntity(tiendaModel, Arrays.asList());

		tiendaEntity.setHabilitado(true);
		tiendaModel = tiendaConverter.tiendaEntityToTiendaModel(tiendaService.create(tiendaEntity), Arrays.asList());

		return new ResponseEntity<>(tiendaModel, HttpStatus.CREATED);
	}

	@PutMapping("tiendas/{id}")
	public ResponseEntity<Object> update(@RequestBody TiendaModel tiendaModel, @PathVariable Long id) {
		TiendaEntity tiendaEntity = tiendaConverter.tiendaModelToTiendaEntity(tiendaModel, Arrays.asList());
		tiendaEntity.setId(id);
		tiendaEntity.setHabilitado(true);
		tiendaModel = tiendaConverter.tiendaEntityToTiendaModel(tiendaService.update(tiendaEntity), Arrays.asList());

		return new ResponseEntity<>(tiendaModel, HttpStatus.ACCEPTED);
	}

	@GetMapping("/tiendas/{id}")
	public ResponseEntity<Object> view(@PathVariable Long id) {

		TiendaEntity tiendaEntity = tiendaService.view(id);

		if (tiendaEntity == null) {
			return new ResponseEntity<Object>("No existe el id: " + id, HttpStatus.ACCEPTED);
		}

		TiendaModel tiendaModel = tiendaConverter.tiendaEntityToTiendaModel(tiendaEntity, Arrays.asList());

		return new ResponseEntity<Object>(tiendaModel, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/tiendas/{id}/{status}")
	public ResponseEntity<Object> enable(@PathVariable Long id, @PathVariable boolean status){
		
		boolean statusNow = tiendaService.enable(id, status);
		
		Map<String, Object> result = new HashMap<>();
		result.put("habilitado", statusNow);
		
		return new ResponseEntity<Object>(result,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/tiendas")
	public ResponseEntity<Object> List(){
		
		java.util.List<TiendaEntity> tiendaEntities = tiendaService.list();
		
		return new ResponseEntity<Object>(tiendaEntities,HttpStatus.ACCEPTED);
	}
	
	
}

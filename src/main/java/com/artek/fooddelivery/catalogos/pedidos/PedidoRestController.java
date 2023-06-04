package com.artek.fooddelivery.catalogos.pedidos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = { "*" })
@RequestMapping("/api")
@RestController
public class PedidoRestController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoConverter pedidoConverter;

	@PostMapping("/pedidos")
	public ResponseEntity<Object> create(@RequestBody PedidoModel pedidoModel) {

		PedidoEntity pedidoEntity = pedidoConverter.pedidoModelToPedidoEntity(pedidoModel);

		pedidoEntity.setHabilitado(true);
		pedidoModel = pedidoConverter.pedidoEntityToPedidoModel(pedidoService.create(pedidoEntity));

		return new ResponseEntity<>(pedidoModel, HttpStatus.CREATED);
	}

	@PutMapping("pedidos/{id}")
	public ResponseEntity<Object> update(@RequestBody PedidoModel pedidoModel, @PathVariable Long id) {
		PedidoEntity pedidoEntity = pedidoConverter.pedidoModelToPedidoEntity(pedidoModel);
		pedidoEntity.setId(id);
		pedidoEntity.setHabilitado(true);
		pedidoModel = pedidoConverter.pedidoEntityToPedidoModel(pedidoService.update(pedidoEntity));

		return new ResponseEntity<>(pedidoModel, HttpStatus.ACCEPTED);
	}

	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Object> view(@PathVariable Long id) {

		PedidoEntity pedidoEntity = pedidoService.view(id);

		if (pedidoEntity == null) {
			return new ResponseEntity<Object>("No existe el id: " + id, HttpStatus.ACCEPTED);
		}

		PedidoModel pedidoModel = pedidoConverter.pedidoEntityToPedidoModel(pedidoEntity);

		return new ResponseEntity<Object>(pedidoModel, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/pedidos/{id}/{status}")
	public ResponseEntity<Object> enable(@PathVariable Long id, @PathVariable boolean status){
		
		boolean statusNow = pedidoService.enable(id, status);
		
		Map<String, Object> result = new HashMap<>();
		result.put("habilitado", statusNow);
		
		return new ResponseEntity<Object>(result,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<Object> list(){
		
		java.util.List<PedidoEntity> pedidoEntities = pedidoService.list();
		
		return new ResponseEntity<Object>(pedidoEntities,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/pedidos/usuarios/{id}")
	public ResponseEntity<Object> findByIdUsuario(@PathVariable Long id){
		
		java.util.List<PedidoEntity> pedidoEntities = pedidoService.findByIdUsuario(id);
		
		return new ResponseEntity<Object>(pedidoEntities,HttpStatus.ACCEPTED);
	}
}

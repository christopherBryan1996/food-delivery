package com.artek.fooddelivery.catalogos.productos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class productoRestController {
	
	//pruebas 
	@GetMapping("/clientes")
	public ResponseEntity<String> pueba(){
		return new ResponseEntity<String>("hola",HttpStatus.ACCEPTED);
	}
}

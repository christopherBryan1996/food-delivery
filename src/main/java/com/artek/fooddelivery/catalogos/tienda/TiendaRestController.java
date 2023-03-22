package com.artek.fooddelivery.catalogos.tienda;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TiendaRestController {
	
	//pruebas 
	@GetMapping("/clientes2")
	public ResponseEntity<String> pueba(){
		return new ResponseEntity<String>("holafff",HttpStatus.ACCEPTED);
	}
}

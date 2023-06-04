package com.artek.fooddelivery.catalogos.productos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class productoRestController {
	
	@Autowired
	private ProductoConverter productoConverter;
	
	@Autowired 
	private ProductoService productoService;
	
	@PostMapping("/productos")
	public ResponseEntity<Object> create(@RequestBody ProductoModel productoModel){	
		
		ProductoEntity productoEntity = productoConverter.productoModelToProductoEntity(productoModel);
		
		productoEntity.setHabilitado(true);
		productoModel = productoConverter.productEntityToProductoModel(productoService.create(productoEntity));
		
		return new ResponseEntity<Object>(productoModel,HttpStatus.CREATED);
	}
	@PostMapping("/productos/{id}")
	public ResponseEntity<Object> createi(@RequestParam("file") MultipartFile image,@PathVariable Long id){
		
		ProductoEntity productoEntity = productoService.view(id);
		
		if(!image.isEmpty()) {
			java.nio.file.Path directorioImagenes =  Paths.get("src//main//resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = image.getBytes();
				java.nio.file.Path rutacompleta = Paths.get(rutaAbsoluta + "//" + image.getOriginalFilename());
				Files.write(rutacompleta, bytesImg);
			
				productoEntity.setImage(rutaAbsoluta+"//"+image.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		productoService.create(productoEntity);
		return new ResponseEntity<Object>("d",HttpStatus.CREATED);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Object> view(@PathVariable Long id){
		
		ProductoEntity productoEntity = productoService.view(id);
		ProductoModel productoModel = productoConverter.productEntityToProductoModel(productoEntity);
		return new ResponseEntity<Object>(productoModel,HttpStatus.CREATED);
	}
}

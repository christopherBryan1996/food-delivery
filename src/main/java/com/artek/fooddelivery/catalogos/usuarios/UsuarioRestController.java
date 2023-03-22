package com.artek.fooddelivery.catalogos.usuarios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"*"})
@RequestMapping("/api")
@RestController
public class UsuarioRestController {
	
	@Autowired
	private UsuarioConverter usuarioConverter;
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Object> create(@RequestBody UsuarioModel usuarioModel){
		
		UsuarioEntity usuarioEntity = usuarioConverter.usuarioModelToUsuarioEntity(usuarioModel, Arrays.asList());
		
		boolean exist = usuarioService.existsByNombreUsuario(usuarioEntity.getNombreUsuario());
		
		if(exist) {
			return new ResponseEntity<Object>("Ya existe el usuario: "+ usuarioEntity.getNombreUsuario(),HttpStatus.BAD_REQUEST);
		}
		
		usuarioEntity.setHabilitado(true);
		usuarioModel = usuarioConverter.usuarioEntityToUsuarioModel(usuarioService.create(usuarioEntity), Arrays.asList());
		
		return new ResponseEntity<Object>(usuarioModel,HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> update(@RequestBody UsuarioModel usuarioModel, @PathVariable Long id){
		
		UsuarioEntity usuarioEntity = usuarioConverter.usuarioModelToUsuarioEntity(usuarioModel, Arrays.asList());
		
		usuarioEntity.setId(id);
		
		usuarioModel = usuarioConverter.usuarioEntityToUsuarioModel(usuarioService.create(usuarioEntity), Arrays.asList());
		
		return new ResponseEntity<Object>(usuarioModel,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Object> view(@PathVariable Long id){
		
		UsuarioEntity usuarioEntity = usuarioService.view(id);
		
		if(usuarioEntity==null) {
			return new ResponseEntity<Object>("No existe el id: "+ id,HttpStatus.ACCEPTED);
		}
		
		UsuarioModel usuarioModel = usuarioConverter.usuarioEntityToUsuarioModel(usuarioEntity, Arrays.asList());
		
		return new ResponseEntity<Object>(usuarioModel,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/usuarios/{id}/{status}")
	public ResponseEntity<Object> enable(@PathVariable Long id, @PathVariable boolean status){
		
		boolean statusNow = usuarioService.enable(id, status);
		
		Map<String, Object> result = new HashMap<>();
		result.put("habilitado", statusNow);
		
		return new ResponseEntity<Object>(result,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/usuarios/sesion")
	public ResponseEntity<Object> sesion(@RequestBody UsuarioModel usuarioModel){
		
		String password = usuarioModel.getPassword();
		
		UsuarioEntity usuarioEntity = usuarioService.findByNombreUsuario(usuarioModel.getNombreUsuario());
		Map<String, Object> resultDont = new HashMap<>();
		resultDont.put("Usuario", null);
		resultDont.put("jwt", false);

		if(usuarioEntity == null) {
			return new ResponseEntity<Object>(resultDont,HttpStatus.BAD_REQUEST);
		}
		
		usuarioModel = usuarioConverter.usuarioEntityToUsuarioModel(usuarioEntity, Arrays.asList());
		
		if(password.equals(usuarioModel.getPassword())) {
			Map<String, Object> result = new HashMap<>();
			result.put("Usuario", usuarioModel);
			result.put("jwt", password.equals(usuarioModel.getPassword()));
			return new ResponseEntity<Object>(result,HttpStatus.ACCEPTED);			
		}else {
			return new ResponseEntity<Object>(resultDont,HttpStatus.BAD_REQUEST);
		}
	}
}

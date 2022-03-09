package com.playcog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.playcog.dto.MostrarUsuariosDTO;
import com.playcog.dto.UsuarioDTO;
import com.playcog.entity.UsuarioEntity;
import com.playcog.repository.UsuarioRepository;

@RestController//api rest
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//CREATE
	@RequestMapping(path = "crearUsuario", method = RequestMethod.POST)
	public ResponseEntity<Void> Crear(@RequestBody UsuarioDTO usuarioNuevo) {
		
		UsuarioEntity nuevoUsuario = new UsuarioEntity();//instancia de la entidad
		nuevoUsuario.setNombre(usuarioNuevo.getNombre());//obtiene los datos
		nuevoUsuario.setApellido(usuarioNuevo.getApellido());
		nuevoUsuario.setCorreo(usuarioNuevo.getCorreo());
		nuevoUsuario.setContrasena(usuarioNuevo.getContrasena());
		nuevoUsuario.setFecha_nacimiento(usuarioNuevo.getFecha_nacimiento());
		nuevoUsuario.setTelefono(usuarioNuevo.getTelefono());
		nuevoUsuario.setResidencia(usuarioNuevo.getResidencia());
		
		usuarioRepository.save(nuevoUsuario);//guardado en base de datos
		return ResponseEntity.ok(null);
	}
	
	//READ
	@RequestMapping(path = "mostrarUsuario", method = RequestMethod.GET)
	public ResponseEntity<MostrarUsuariosDTO> Mostrar() {
		
		MostrarUsuariosDTO listaDeUsuarios = new MostrarUsuariosDTO();
		
		listaDeUsuarios.setUsuarios(usuarioRepository.findAll());
		return ResponseEntity.ok(listaDeUsuarios);
	}
	
	//READbyID
	@RequestMapping(path = "mostrarUsuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioEntity> MostrarById(@PathVariable int id) {
		
		UsuarioEntity usuarioById = usuarioRepository.findById(id);
		
		return ResponseEntity.ok(usuarioById);
	}
	
	//UPDATE
	@RequestMapping(path = "actualizarUsuario/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> Actualizar(@PathVariable int id, @RequestBody UsuarioDTO usuarioActualizado) {
		
		UsuarioEntity usuarioAActualizar = usuarioRepository.findById(id);
		
		usuarioAActualizar.setNombre(usuarioActualizado.getNombre());//obtiene los datos
		usuarioAActualizar.setApellido(usuarioActualizado.getApellido());
		usuarioAActualizar.setCorreo(usuarioActualizado.getCorreo());
		usuarioAActualizar.setContrasena(usuarioActualizado.getContrasena());
		usuarioAActualizar.setFecha_nacimiento(usuarioActualizado.getFecha_nacimiento());
		usuarioAActualizar.setTelefono(usuarioActualizado.getTelefono());
		usuarioAActualizar.setResidencia(usuarioActualizado.getResidencia());
		usuarioRepository.save(usuarioAActualizar);
		
		System.out.println("Usuario actualizado");
		
		return ResponseEntity.ok().body(null);
	}
			
	//DELETE
	@RequestMapping(path = "eliminarUsuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> Eliminar(@PathVariable int id) {
		
		UsuarioEntity usuarioAEliminar = usuarioRepository.findById(id);//asigna a usuarioAEliminar, el usuario encontrado por nombre en el repositorio
		usuarioRepository.delete(usuarioAEliminar);
		
		System.out.println("Usuario eliminado");
		
		return ResponseEntity.ok().body(null);
	}

}

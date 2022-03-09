package com.playcog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.playcog.dto.MostrarProgresosDTO;
import com.playcog.dto.ProgresoDTO;
import com.playcog.dto.VideojuegoDTO;
import com.playcog.entity.CategoriaEntity;
import com.playcog.entity.ProgresoEntity;
import com.playcog.entity.UsuarioEntity;
import com.playcog.entity.VideojuegoEntity;
import com.playcog.repository.ProgresoRepository;
import com.playcog.repository.UsuarioRepository;
import com.playcog.repository.VideojuegoRepository;

@RestController
public class ProgresoController {
	@Autowired
	private ProgresoRepository progresoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VideojuegoRepository videojuegoRepository;
	
	//CREATE
	@RequestMapping(path = "/videojuego/{videojuego}/usuario/{usuario}/crearProgreso", method = RequestMethod.POST)
	public ResponseEntity<Void> Crear(@PathVariable int videojuego,@PathVariable int usuario,@RequestBody ProgresoDTO progresoNuevo){
		
		ProgresoEntity nuevoProgreso = new ProgresoEntity();
		VideojuegoEntity videojuegoID = videojuegoRepository.findById(videojuego);
		UsuarioEntity usuarioID = usuarioRepository.findById(usuario);

		nuevoProgreso.setVideojuego(videojuegoID);
		nuevoProgreso.setUsuario(usuarioID);
		nuevoProgreso.setInformacion(progresoNuevo.getInformacion());
		
		progresoRepository.save(nuevoProgreso);
		
		System.out.println("Pregreso de usuario " +  usuario + " creado");
		
		return ResponseEntity.ok().body(null);
		
	}
	
	//READ
    @RequestMapping(path = "mostrarProgreso", method = RequestMethod.GET )
    public ResponseEntity<MostrarProgresosDTO> listar(){

    	MostrarProgresosDTO capturarProgresos = new MostrarProgresosDTO();
    	capturarProgresos.setProgresos(progresoRepository.findAll());
        return ResponseEntity.ok().body(capturarProgresos);
    }
    
    //READbyID
  	@RequestMapping(path = "mostrarProgreso/{id}", method = RequestMethod.GET)
  	public ResponseEntity<ProgresoEntity> MostrarbyId(@PathVariable int id){
  		
  		ProgresoEntity juego = progresoRepository.findById(id);
  		
  		return ResponseEntity.ok().body(juego);
  		
  	} 
  	
  //UPDATE
  	@RequestMapping(path = "/videojuego/{videojuego}/usuario/{usuario}/actualizarProgreso", method = RequestMethod.PUT)
  	public ResponseEntity<Void> Actualizar(@PathVariable int videojuego, @PathVariable int usuario,@RequestBody ProgresoDTO progresoActualizado){
  		
  		ProgresoEntity progresoAActualizar = new ProgresoEntity();
		VideojuegoEntity videojuegoID = videojuegoRepository.findById(videojuego);
		UsuarioEntity usuarioID = usuarioRepository.findById(usuario);

		progresoAActualizar.setVideojuego(videojuegoID);
		progresoAActualizar.setUsuario(usuarioID);
		progresoAActualizar.setInformacion(progresoActualizado.getInformacion());
		
		progresoRepository.save(progresoAActualizar);
		
		System.out.println("Pregreso de usuario " +  usuario + " actualizado");
		
		return ResponseEntity.ok().body(null);
  	}
  	
  	//DELETE
  	@RequestMapping(path = "eliminarProgreso/{id}", method = RequestMethod.GET)
  	public ResponseEntity<Void> Eliminar(@PathVariable int id) {
  		
  		ProgresoEntity progresoAEliminar = progresoRepository.findById(id);
  		progresoRepository.delete(progresoAEliminar);
  		
  		System.out.println("Progreso eliminado");
  		
  		return ResponseEntity.ok().body(null);
  	}
}

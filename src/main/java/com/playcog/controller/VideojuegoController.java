package com.playcog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.playcog.dto.MostrarVideojuegosDTO;
import com.playcog.dto.VideojuegoDTO;
import com.playcog.entity.CategoriaEntity;
import com.playcog.entity.VideojuegoEntity;
import com.playcog.repository.CategoriaRepository;
import com.playcog.repository.VideojuegoRepository;

@RestController
public class VideojuegoController {

	@Autowired
	private VideojuegoRepository videojuegoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//CREATE
	
	@RequestMapping(path = "crearJuego/{categoria}", method = RequestMethod.POST)
	public ResponseEntity<Void> Crear(@PathVariable int categoria,@RequestBody VideojuegoDTO juegoNuevo){
		
		VideojuegoEntity nuevoJuego = new VideojuegoEntity();
		CategoriaEntity categoriaID = categoriaRepository.findById(categoria);
		nuevoJuego.setNombre_videojuego(juegoNuevo.getNombre_videojuego());
		nuevoJuego.setDescripcion_videojuego(juegoNuevo.getDescripcion_videojuego());
		nuevoJuego.setCategoria(categoriaID);
		
		videojuegoRepository.save(nuevoJuego);
		
		System.out.println("Videojuego creado");
		
		return ResponseEntity.ok().body(null);
		
	}
	
	//READ
    @RequestMapping(path = "mostrarJuego", method = RequestMethod.GET )
    public ResponseEntity<MostrarVideojuegosDTO> listar(){

    	MostrarVideojuegosDTO capturarVideojuego = new MostrarVideojuegosDTO();
        capturarVideojuego.setJuegos(videojuegoRepository.findAll());
        return ResponseEntity.ok().body(capturarVideojuego);
    }
	
	//READbyID
	@RequestMapping(path = "mostrarJuego/{id}", method = RequestMethod.GET)
	public ResponseEntity<VideojuegoEntity> MostrarbyId(@PathVariable int id){
		
		VideojuegoEntity juego = videojuegoRepository.findById(id);
		
		return ResponseEntity.ok().body(juego);
		
	} 
	
	//UPDATE
	@RequestMapping(path = "actualizarJuego/{id}/categoria/{categoria}", method = RequestMethod.PUT)
	public ResponseEntity<Void> Actualizar(@PathVariable int id, @PathVariable int categoria,@RequestBody VideojuegoDTO juegoActualizado){
		
		VideojuegoEntity juegoAActualizar = videojuegoRepository.findById(id);
		CategoriaEntity categoriaID = categoriaRepository.findById(categoria);
		
		juegoAActualizar.setNombre_videojuego(juegoActualizado.getNombre_videojuego());
		juegoAActualizar.setCategoria(categoriaID);
		juegoAActualizar.setDescripcion_videojuego(juegoActualizado.getDescripcion_videojuego());
		
		System.out.println("Videojuego actualizado");
		
		return ResponseEntity.ok().body(null);
	}
	
	//DELETE
	@RequestMapping(path = "eliminarJuego/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> Eliminar(@PathVariable int id) {
		
		VideojuegoEntity juegoAEliminar = videojuegoRepository.findById(id);
		videojuegoRepository.delete(juegoAEliminar);
		
		System.out.println("Juego eliminado");
		
		return ResponseEntity.ok().body(null);
	}
}

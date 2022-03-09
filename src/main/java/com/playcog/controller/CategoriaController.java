package com.playcog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.playcog.dto.CategoriaDTO;
import com.playcog.dto.MostrarCategoriasDTO;
import com.playcog.entity.CategoriaEntity;
import com.playcog.repository.CategoriaRepository;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//CREATE
	@RequestMapping(path = "crearCategoria", method = RequestMethod.POST)
	public ResponseEntity<Void> Crear(@RequestBody CategoriaDTO categoriaNueva) {
		
		CategoriaEntity nuevaCategoria = new CategoriaEntity();//instancia de la entidad
		nuevaCategoria.setNombre_categoria(categoriaNueva.getNombre_categoria());//obtiene los datos
		nuevaCategoria.setDescripcion_categoria(categoriaNueva.getDescripcion_categoria());
		
		categoriaRepository.save(nuevaCategoria);//guardado en base de datos
		
		System.out.println("Categoria creada");
		
		return ResponseEntity.ok().body(null);
	}
	
	//READ
	@RequestMapping(path = "mostrarCategoria", method = RequestMethod.GET)
	public ResponseEntity<MostrarCategoriasDTO> Mostrar() {
		
		MostrarCategoriasDTO listaDeCategorias = new MostrarCategoriasDTO();
		
		listaDeCategorias.setCategorias(categoriaRepository.findAll());
		return ResponseEntity.ok().body(listaDeCategorias);
	}
	
	//READbyID
	@RequestMapping(path = "mostrarCategoria/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaEntity> MostrarbyId(@PathVariable int id) {
		
		CategoriaEntity categoria = categoriaRepository.findById(id);

		return ResponseEntity.ok().body(categoria);
	}
	
	//UPDATE
	@RequestMapping(path = "actualizarCategoria/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> Actualizar(@PathVariable int id, @RequestBody CategoriaDTO categoriaActualizado) {
		
		CategoriaEntity categoriaAActualizar = categoriaRepository.findById(id);
		
		categoriaAActualizar.setNombre_categoria(categoriaActualizado.getNombre_categoria());
		categoriaAActualizar.setDescripcion_categoria(categoriaActualizado.getDescripcion_categoria());

		categoriaRepository.save(categoriaAActualizar);
		
		System.out.println("Categoria actualizada");
		
		return ResponseEntity.ok().body(null);
	}
		
	//DELETE
	@RequestMapping(path = "eliminarCategoria/{id}", method = RequestMethod.GET)
	public ResponseEntity<Void> Eliminar(@PathVariable int id) {
		
		CategoriaEntity categoriaAEliminar = categoriaRepository.findById(id);//asigna a usuarioAEliminar, el usuario encontrado por nombre en el repositorio
		categoriaRepository.delete(categoriaAEliminar);
		
		System.out.println("Categoria eliminada");
		
		return ResponseEntity.ok().body(null);
	}
}

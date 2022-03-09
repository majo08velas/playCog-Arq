package com.playcog.dto;

import java.util.List;

import com.playcog.entity.VideojuegoEntity;

public class CategoriaDTO {
	
	private String nombre_categoria;
	
	private String descripcion_categoria;


	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}
	
	

}

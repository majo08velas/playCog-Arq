package com.playcog.dto;

import java.util.List;

import com.playcog.entity.CategoriaEntity;

public class VideojuegoDTO {//lo que quiero ver y recibir
	
	private CategoriaEntity categoria;
	
	private String nombre_videojuego;
	
	private String descripcion_videojuego;

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public String getNombre_videojuego() {
		return nombre_videojuego;
	}

	public void setNombre_videojuego(String nombre_videojuego) {
		this.nombre_videojuego = nombre_videojuego;
	}

	public String getDescripcion_videojuego() {
		return descripcion_videojuego;
	}

	public void setDescripcion_videojuego(String descripcion_videojuego) {
		this.descripcion_videojuego = descripcion_videojuego;
	}
	
	
}

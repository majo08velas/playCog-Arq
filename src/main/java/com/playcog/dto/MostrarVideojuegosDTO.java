package com.playcog.dto;

import java.util.List;

import com.playcog.entity.VideojuegoEntity;

public class MostrarVideojuegosDTO {

	public List<VideojuegoEntity> juegos;

	public List<VideojuegoEntity> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<VideojuegoEntity> juegos) {
		this.juegos = juegos;
	}
	
	
}

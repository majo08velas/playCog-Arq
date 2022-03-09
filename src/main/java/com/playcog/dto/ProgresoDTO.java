package com.playcog.dto;

import com.playcog.entity.UsuarioEntity;
import com.playcog.entity.VideojuegoEntity;

public class ProgresoDTO {
	
	private VideojuegoEntity videojuego;
	
	private UsuarioEntity usuario;
	
	private String informacion;

	public VideojuegoEntity getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(VideojuegoEntity videojuego) {
		this.videojuego = videojuego;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
	
}

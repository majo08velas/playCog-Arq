package com.playcog.dto;

import java.util.List;

import com.playcog.entity.UsuarioEntity;

public class MostrarUsuariosDTO {

	private List<UsuarioEntity> usuarios;

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
}

package com.playcog.dto;

import java.util.List;

import com.playcog.entity.CategoriaEntity;

public class MostrarCategoriasDTO {
	
	private List<CategoriaEntity> categorias;

	public List<CategoriaEntity> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaEntity> categorias) {
		this.categorias = categorias;
	}
	
	

}

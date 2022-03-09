package com.playcog.dto;

import java.util.List;

import com.playcog.entity.ProgresoEntity;

public class MostrarProgresosDTO {//lista de progresos

	public List<ProgresoEntity> progresos;

	public List<ProgresoEntity> getProgresos() {
		return progresos;
	}

	public void setProgresos(List<ProgresoEntity> progresos) {
		this.progresos = progresos;
	}
	
	

}

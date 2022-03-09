package com.playcog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "progreso")
public class ProgresoEntity {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "progreso_seq_generator")
	@SequenceGenerator(
            name = "progreso_seq_generator",
            sequenceName = "progreso_id_seq",
            allocationSize = 1)
	@Column(name = "id")
	private int id;
	
	@ManyToOne//para tabla hija
	@JoinColumn(name = "id_videojuego")
	private VideojuegoEntity videojuego;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuario;
	
	@Column(name = "informacion")
	private String informacion;
	
	//getter y setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
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
	
	
	// Constructor
	
	public ProgresoEntity(){
		
	}

}

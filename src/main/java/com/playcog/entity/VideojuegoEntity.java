package com.playcog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "videojuego")
public class VideojuegoEntity {

	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "videojuego_seq_generator")
	@SequenceGenerator(
            name = "videojuego_seq_generator",
            sequenceName = "videojuego_id_seq",
            allocationSize = 1)
	@Column(name = "id")
	private int id;
	
	@ManyToOne//muchos a uno
	@JoinColumn(name = "id_categoria")
	private CategoriaEntity categoria;
	
	@Column(name = "nombre")
	private String nombre_videojuego;
	
	@Column(name = "descripcion")
	private String descripcion_videojuego;
	
	//getter y setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	
	//Constructor

	public VideojuegoEntity(){
		
	}
}

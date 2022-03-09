package com.playcog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "categoria_seq_generator")
	@SequenceGenerator(
            name = "categoria_seq_generator",
            sequenceName = "categoria_id_seq",
            allocationSize = 1)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre_categoria;
	
	@Column(name = "descripcion")
	private String descripcion_categoria;
	
	//getter y setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	
	//Constructor

	public CategoriaEntity(){
		
	}

}

package com.playcog.entity;

import java.time.LocalDate;
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
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "usuario_seq_generator")
	@SequenceGenerator(
            name = "usuario_seq_generator",
            sequenceName = "usuario_id_seq",
            allocationSize = 1)//la bd genera un id cada vez que se crea un registro
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "contraseña")
	private String contrasena;

	@Column(name = "fecha_nacimiento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="EST")
	private LocalDate fecha_nacimiento;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "residencia")
	private String residencia;

	public int getId() {
		return id;
	}

	//getter y setter

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	//constructor por default requerido por JPA


	public UsuarioEntity(){
		
	}

}

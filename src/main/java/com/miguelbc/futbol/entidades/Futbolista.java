package com.miguelbc.futbol.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Futbolista")
public class Futbolista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//nombre apellido añonacimiento nacionalidad nif
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 15, message = "el tamaño tiene que estar entre 4 y 15")
	private String nombre;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
	private String apellido;
	
	private Date fechaNac;
	
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12")
	private String nacionalidad;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 9, message = "el tamaño tiene que estar entre 4 y 12")
	private String nif;
	
	@OneToMany(mappedBy = "futbolista")
	private List<EquipoFutbolista> equipofutbolistas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	
}

package com.miguelbc.futbol.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Equipo")
public class Equipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private Date fechaCreacion;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	private String estadio;
	
	@OneToMany(mappedBy="equipo")
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	
	
	
	
	
	
	
}

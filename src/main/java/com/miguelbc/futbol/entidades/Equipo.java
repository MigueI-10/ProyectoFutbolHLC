package com.miguelbc.futbol.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Equipo")
@Data @AllArgsConstructor @NoArgsConstructor
public class Equipo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/***
	 * Id del equipo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/***
	 * Nombre del equipo
	 */
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	@Column(nullable = false)
	private String nombre;

	/***
	 * Fecha de creacion del equipo
	 */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaCreacion;

	/***
	 * Estadio del equipo
	 */
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	private String estadio;

	/***
	 * Lista de equipo futbolista
	 */
	@OneToMany(mappedBy="equipo", cascade = CascadeType.REMOVE)
	private List<EquipoFutbolista> equipofutbolistas;

}

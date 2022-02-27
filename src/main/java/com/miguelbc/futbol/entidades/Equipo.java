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


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	@Column(nullable = false)
	private String nombre;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaCreacion;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	private String estadio;

	@OneToMany(mappedBy="equipo", cascade = CascadeType.REMOVE)

	private List<EquipoFutbolista> equipofutbolistas;










}

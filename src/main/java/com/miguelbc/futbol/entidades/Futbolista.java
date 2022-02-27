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
@Table(name = "Futbolista")
@Data @AllArgsConstructor @NoArgsConstructor
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

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaNac;


	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12")
	private String nacionalidad;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 9, message = "el tamaño tiene que estar entre 4 y 12")
	private String nif;

	@OneToMany(mappedBy = "futbolista", cascade = CascadeType.REMOVE)
	private List<EquipoFutbolista> equipofutbolistas;





}

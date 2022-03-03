package com.miguelbc.futbol.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class EquipoModelo {

	/**
	 * Id del equipo
	 */
	private Long id;

	/**
	 * Nombre del equipo
	 */
	private String nombre;

	/**
	 * Fecha de Creacion del equipo
	 */
	private String fechaCreacion;

	/**
	 * Estadio del equipo
	 */
	private String estadio;




}

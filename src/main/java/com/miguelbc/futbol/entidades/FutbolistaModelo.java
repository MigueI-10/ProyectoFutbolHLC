package com.miguelbc.futbol.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class FutbolistaModelo {

	/**
	 * Id del jugador
	 */
	private Long id;

	//nombre apellido añonacimiento nacionalidad nif

	/***
	 * Nombre del jugador
	 */
	private String nombre;

	/***
	 * Apellido del jugador
	 */
	private String apellido;

	/***
	 * Fecha de Nacimiento del jugador
	 */
	private String fechaNac;

	/***
	 * Nacionalidad del jugador
	 */
	private String nacionalidad;

	/***
	 * Nif del jugador
	 */
	private String nif;





}

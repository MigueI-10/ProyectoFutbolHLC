package com.miguelbc.futbol.entidades;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class FutbolistaModelo {


	private Long id;


	//nombre apellido añonacimiento nacionalidad nif

	private String nombre;

	private String apellido;


	private String fechaNac;


	private String nacionalidad;


	private String nif;


	private List<EquipoFutbolista> equipofutbolistas;




}

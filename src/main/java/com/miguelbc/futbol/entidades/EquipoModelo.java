package com.miguelbc.futbol.entidades;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class EquipoModelo {

	private Long id;

	private String nombre;

	private String fechaCreacion;

	private String estadio;

	private List<EquipoFutbolista> equipofutbolistas;



}

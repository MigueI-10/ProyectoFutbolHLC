package com.miguelbc.futbol.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @AllArgsConstructor @NoArgsConstructor
public class EquipoFutbolistaModelo implements Serializable{

	/**
	 * Id del equipo futbolista
	 */
	private Long id;

	/**
	 * Equipo del equipo futbolista
	 */
    private String equipo;

    /**
	 * Futbolista del equipo futbolista
	 */
    private String futbolista;

    /**
	 * Temporada del equipo futbolista
	 */
    private String temporada;


}

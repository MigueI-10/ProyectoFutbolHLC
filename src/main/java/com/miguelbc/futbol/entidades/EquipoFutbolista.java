package com.miguelbc.futbol.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import javax.validation.*;


@Entity
@Table(name = "EquipoFutbolista")
public class EquipoFutbolista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "equipo_id")
    Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "futbolista_id")
    Futbolista futbolista;
    
    
    private Date temporada;

}

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
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date temporada;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public Futbolista getFutbolista() {
		return futbolista;
	}


	public void setFutbolista(Futbolista futbolista) {
		this.futbolista = futbolista;
	}


	public Date getTemporada() {
		return temporada;
	}


	public void setTemporada(Date temporada) {
		this.temporada = temporada;
	}


	@Override
	public String toString() {
		return "EquipoFutbolista [id=" + id + ", equipo=" + equipo + ", futbolista=" + futbolista + ", temporada="
				+ temporada + "]";
	}
	
	

}

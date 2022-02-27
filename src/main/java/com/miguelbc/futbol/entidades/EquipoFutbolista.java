package com.miguelbc.futbol.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "EquipoFutbolista")
@Data @AllArgsConstructor @NoArgsConstructor
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






}

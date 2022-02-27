package com.miguelbc.futbol.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.entidades.Futbolista;

public interface Repos_Equipo_Futbolista extends JpaRepository<EquipoFutbolista, Long>{


	List <Futbolista> findByEquipoId(Long Id);

	List <Equipo> findByFutbolistaId(Long Id);

	List<EquipoFutbolista> findByTemporada(Date temporada);



}

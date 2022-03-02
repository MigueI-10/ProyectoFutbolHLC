package com.miguelbc.futbol.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.entidades.Futbolista;

public interface Repos_Equipo_Futbolista extends JpaRepository<EquipoFutbolista, Long>{

	@Query(value = "SELECT * FROM futbolista WHERE id_futbolista = ?", nativeQuery = true)
	List <Futbolista> findFutbolistaByEquipoId(Long Id);

	@Query(value = "SELECT * FROM equipo WHERE id_equipo = ?", nativeQuery = true)
	List <Equipo> findEquipoByFutbolistaId(Long Id);

	List<EquipoFutbolista> findByTemporada(Date temporada);

	@Query(value = "SELECT * FROM equipo_futbolista WHERE id = ?", nativeQuery = true)
	List <EquipoFutbolista> findFutbolista(Long Id);
	
	@Query(value = "SELECT * FROM equipo_futbolista WHERE id = ?", nativeQuery = true)
	List <EquipoFutbolista> findEquipo(Long Id);



}

package com.miguelbc.futbol.repositorio;



import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.miguelbc.futbol.entidades.Equipo;

public interface Repos_Equipo extends JpaRepository<Equipo, Long>{

	List<Equipo> findByNombre(String nombre);

	List <Equipo> findByFechaCreacion(Date fechaCreacion);

	List <Equipo> findByEstadio(String estadio);
	
	@Query(value = "SELECT * FROM equipo WHERE id = ?", nativeQuery = true)
	 Equipo findJugadorByID(long idEquipo);



}

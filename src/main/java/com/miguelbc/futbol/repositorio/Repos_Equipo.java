package com.miguelbc.futbol.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miguelbc.futbol.entidades.Equipo;

public interface Repos_Equipo extends JpaRepository<Equipo, Long>{

	/***
	 * Metodo que busca un equipo por nombre
	 * @param nombre del equipo
	 * @return la lista de equipos
	 */
	List<Equipo> findByNombre(String nombre);


	/***
	 * Metodo que busca un equipo por estadio
	 * @param estadio del equipo
	 * @return la lista de equipos
	 */
	List <Equipo> findByEstadio(String estadio);

	/***
	 * Metodo que encuentra un equipo por su id
	 * @param idEquipo del equipo a buscar
	 * @return el objeto equipo
	 */
	@Query(value = "SELECT * FROM equipo WHERE id = ?", nativeQuery = true)
	 Equipo findJugadorByID(long idEquipo);



}

package com.miguelbc.futbol.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miguelbc.futbol.entidades.EquipoFutbolista;

public interface Repos_Equipo_Futbolista extends JpaRepository<EquipoFutbolista, Long>{

	/***
	 * Metodo que devuelve una lista de equipos- futbolistas a partir de su temporada
	 * @param temporada
	 * @return la lista
	 */
	List<EquipoFutbolista> findByTemporada(Date temporada);

	/***
	 * Metodo que devuelve una lista de equipos- futbolistas a partir de su id
	 * @param Id del futbolista a buscar
	 * @return la lista de equipos futbolistas
	 */
	@Query(value = "SELECT * FROM equipo_futbolista WHERE futbolista_id = ?", nativeQuery = true)
	List <EquipoFutbolista> findFutbolista(Long Id);

	/***
	 * Metodo que devuelve una lista de equipos- futbolistas a partir de su id de equipo
	 * @param Id del equipo a buscar
	 * @return la lista de equipos futbolistas
	 */
	@Query(value = "SELECT * FROM equipo_futbolista WHERE equipo_id = ?", nativeQuery = true)
	List <EquipoFutbolista> findEquipo(Long Id);



}

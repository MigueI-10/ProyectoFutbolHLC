package com.miguelbc.futbol.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miguelbc.futbol.entidades.Futbolista;

public interface Repos_Futbolista extends JpaRepository<Futbolista, Long>{

	/***
	 * Metodo que devuelve una lista de jugadores por nombre
	 * @param nombre del jugador a buscar
	 * @return la lista de futbolistas
	 */
	List<Futbolista> findByNombre(String nombre);

	/***
	 * Metodo que devuelve una lista de jugadores por nif
	 * @param nif del jugador a buscar
	 * @return la lista de futbolistas
	 */
	List <Futbolista> findByNif(String nif);

	/***
	 * Metodo que devuelve un jugador por nombre
	 * @param idJugador del jugador a buscar
	 * @return la lista de futbolistas
	 */
	@Query(value = "SELECT * FROM futbolista WHERE id = ?", nativeQuery = true)
	 Futbolista findEquipoByID(long idJugador);


}

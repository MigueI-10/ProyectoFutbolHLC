package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.EquipoFutbolista;

public interface EquipoFutbolistaServiceI {

	/***
	 * Metodo que obtiene todos los Equipos-Futbolistas
	 * @return la lista de Equipos - Futbolista completa
	 */
	public List<EquipoFutbolista> obtenerTodosEquiposFut();

	/***
	 * Metodo que obtiene todos los Equipos-Futbolistas de un determinado jugador a través de su id
	 * @param idFutbolista es la id del futbolista a buscar
	 * @return la lista de Equipos - Futbolista de un determinado jugador
	 */
	public List<EquipoFutbolista> obtenerHistoriaFutbolista(final long idFutbolista);

	/***
	 * Metodo que obtiene todos los Equipos-Futbolistas de un determinado equipo a través de su id
	 * @param idClub es la id del club a buscar
	 * @return  la lista de Equipos - Futbolista de un determinado club
	 */
	public List<EquipoFutbolista> obtenerHistoriaClub(final long idClub);

	/***
	 *  Metodo que elimina un EquipoFutbolista de la base de datos
	 * @param id del objeto para eliminar
	 */
	public void eliminarEquipoFutPorId(final long id);

	/***
	 * Metodo que añade un EquipoFutbolista a la base de datos
	 * @param equipo a insertar
	 */
	public void aniadirEquipoFut(final EquipoFutbolista equipo);

	/***
	 * Metodo que actualiza un Objeto Equipo-Futbolista
	 * @param equipo a actualizar
	 */

	public void actualizarEquipoFut(final EquipoFutbolista equipo);

}

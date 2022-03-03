package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.Equipo;



public interface EquipoServiceI {

	/***
	 * Metodo que nos devuelve una lista con todos los equipos de la base de datos
	 * @return la lista de equipos de la bd
	 */
	public List<Equipo> obtenerTodosEquipos();

	/***
	 * Metodo por el cual obtenemos un objeto equipo a traves de un id
	 * @param id del equipo a volcar
	 * @return El objeto equipo
	 */
	public Equipo obtenerEquipoPorId(final long id);

	/***
	 * Metodo que obtiene una lista de equipos buscando por nombre
	 * @param nombre del equipo a buscar
	 * @return la lista de equipos buscados
	 */
	public List<Equipo> obtenerEquipoPorNombre(final String nombre);

	/***
	 * Metodo que obtiene una lista de equipos buscando por estadio
	 * @param estadio del equipo a buscar
	 * @return la lista de equipos buscados
	 */

	public List<Equipo> obtenerEquipoPorEstadio(final String estadio);

	/***
	 * Metodo que elimina un equipo de la base de datos por el id
	 * @param id del Equipo a borrar
	 */
	public void eliminarEquipoPorId(final long id);

	/***
	 * Metodo que añade un equipo a la base de datos
	 * @param equipo a insertar
	 */
	public void aniadirEquipo(final Equipo equipo);

	/***
	 * Metodo que sirve para actualizar un equipo de la base de datos
	 * @param equipo a actualizar
	 */
	public void actualizarEquipo(final Equipo equipo);

}

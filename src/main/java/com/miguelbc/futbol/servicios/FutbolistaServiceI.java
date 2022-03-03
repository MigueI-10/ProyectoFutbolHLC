package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.Futbolista;

public interface FutbolistaServiceI {

	/***
	 * Metodo que nos devuelve una lista con todos los jugadores
	 * @return Retorna la lista con todos los futbolistas
	 */
	public List<Futbolista> obtenerTodosFutbolistas();

	/***
	 * Metodo que obtiene un futbolista por su id
	 * @param id del jugador a buscar
	 * @return un objeto futbolista
	 */
	public Futbolista obtenerFutbolistaPorId(final long id);

	/***
	 * Metodo que busca futbolistas por nombre
	 * @param nombre del jugador a buscar
	 * @return la lista de futbolistas
	 */
	public List<Futbolista> obtenerFutbolistaPorNombre(final String nombre);

	/***
	 * Metodo que busca futbolistas por nif
	 * @param nif del jugador a buscar
	 * @return la lista de futbolistas
	 */
	public List<Futbolista> obtenerFutbolistaPorNif(final String nif);

	/***
	 * Metodo que elimina un futbolista por su id
	 * @param id del jugador a eliminar
	 */
	public void eliminarFutbolistaPorId(final long id);

	/***
	 * Metodo que añade un futbolista a la base de datos
	 * @param player a insertar
	 */
	public void aniadirFutbolista(final Futbolista player);

	/***
	 * Metodo que actualiza un futbolista
	 * @param player a actualizar
	 */
	public void actualizarFutbolista(final Futbolista player);



}

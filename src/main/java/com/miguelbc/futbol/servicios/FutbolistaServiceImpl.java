package com.miguelbc.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelbc.futbol.entidades.Futbolista;
import com.miguelbc.futbol.repositorio.Repos_Futbolista;

@Service
public class FutbolistaServiceImpl implements FutbolistaServiceI{

	@Autowired
	private Repos_Futbolista service;

	/**
	 * Metodo que nos devuelve una lista con todos los jugadores
	 */
	@Override
	public List<Futbolista> obtenerTodosFutbolistas() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	/***
	 * Elimina un futbolista de la base de datos
	 */
	@Override
	public void eliminarFutbolistaPorId(long id) {
		// TODO Auto-generated method stub
		service.deleteById(id);
	}

	/***
	 * Añade un jugador a la base de datos
	 */
	@Override
	public void aniadirFutbolista(Futbolista player) {
		// TODO Auto-generated method stub
		service.save(player);
	}

	/***
	 * Metodo que actualiza un futbolista
	 * @param player a actualizar
	 */
	@Override
	public void actualizarFutbolista(Futbolista player) {
		// TODO Auto-generated method stub
		service.save(player);
	}

	/***
	 * Metodo que busca futbolistas por nombre
	 * @param nombre del jugador a buscar
	 * @return la lista de futbolistas
	 */
	@Override
	public List<Futbolista> obtenerFutbolistaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return service.findByNombre(nombre);
	}

	/***
	 * Metodo que busca futbolistas por nif
	 * @param nif del jugador a buscar
	 * @return la lista de futbolistas
	 */

	@Override
	public List<Futbolista> obtenerFutbolistaPorNif(String nif) {
		// TODO Auto-generated method stub
		return service.findByNif(nif);
	}

	/***
	 * Metodo que obtiene un futbolista por su id
	 * @param id del jugador a buscar
	 * @return un objeto futbolista
	 */
	@Override
	public Futbolista obtenerFutbolistaPorId(long id) {
		// TODO Auto-generated method stub
		Futbolista f = service.findEquipoByID(id);
		return f;
	}

}

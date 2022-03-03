package com.miguelbc.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.repositorio.Repos_Equipo_Futbolista;

@Service
public class EquipoFutbolistaServiceImpl implements EquipoFutbolistaServiceI{

	@Autowired
	private Repos_Equipo_Futbolista service;

	/***
	 * Metodo que encuentra todos los equipos futbolistas de la base de datos
	 */
	@Override
	public List<EquipoFutbolista> obtenerTodosEquiposFut() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	/***
	 * Elimina un equipo - futbolista por id
	 */
	@Override
	public void eliminarEquipoFutPorId(long id) {
		// TODO Auto-generated method stub
		service.deleteById(id);
	}

	/***
	 * Añade un objeto a la base de datos
	 */
	@Override
	public void aniadirEquipoFut(EquipoFutbolista equipo) {
		// TODO Auto-generated method stub
		service.save(equipo);
	}

	/***
	 * Actualiza un objeto de la base de datos
	 */
	@Override
	public void actualizarEquipoFut(EquipoFutbolista equipo) {
		// TODO Auto-generated method stub
		service.save(equipo);
	}

	/***
	 * Metodo que obtiene un equipo-futbolista por la id de futbolista
	 */

	@Override
	public List<EquipoFutbolista> obtenerHistoriaFutbolista(long idFutbolista) {
		// TODO Auto-generated method stub
		return service.findFutbolista(idFutbolista);
	}

	/***
	 * Metodo que obtiene un equipo-futbolista por la id de equipo
	 */
	@Override
	public List<EquipoFutbolista> obtenerHistoriaClub(long idClub) {
		// TODO Auto-generated method stub
		return service.findEquipo(idClub);
	}



}

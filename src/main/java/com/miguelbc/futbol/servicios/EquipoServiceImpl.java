package com.miguelbc.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.repositorio.Repos_Equipo;

@Service
public class EquipoServiceImpl implements EquipoServiceI{

	@Autowired
	private Repos_Equipo serviceI;

	/***
	 * Metodo que devuelve una lista con todos los equipos de la bd
	 */
	@Override
	public List<Equipo> obtenerTodosEquipos() {
		// TODO Auto-generated method stub
		return serviceI.findAll();
	}

	/***
	 * Metodo que elimina un equipo en la base de datos
	 */
	@Override
	public void eliminarEquipoPorId(long id) {
		// TODO Auto-generated method stub
		serviceI.deleteById(id);
	}

	/***
	 * Metodo que inserta un equipo en la base de datos
	 */
	@Override
	public void aniadirEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		serviceI.save(equipo);
	}

	/***
	 * Metodo que actualiza un equipo de la base de datos
	 */
	@Override
	public void actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		serviceI.save(equipo);
	}

	@Override
	public List<Equipo> obtenerEquipoPorEstadio(String estadio) {
		// TODO Auto-generated method stub
		return serviceI.findByEstadio(estadio);
	}

	/***
	 * Metodo que devuelve una lista de equipos buscando por nombres
	 */
	@Override
	public List<Equipo> obtenerEquipoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return serviceI.findByNombre(nombre);
	}


	/***
	 * Metodo que obtiene un equipo por id
	 */
	@Override
	public Equipo obtenerEquipoPorId(long id) {
		// TODO Auto-generated method stub
		Equipo e = serviceI.findJugadorByID(id);
		return e;
	}



}

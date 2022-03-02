package com.miguelbc.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.entidades.Futbolista;
import com.miguelbc.futbol.repositorio.Repos_Equipo_Futbolista;

@Service
public class EquipoFutbolistaServiceImpl implements EquipoFutbolistaServiceI{

	@Autowired
	private Repos_Equipo_Futbolista service;

	@Override
	public List<EquipoFutbolista> obtenerTodosEquiposFut() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public void eliminarEquipoFutPorId(long id) {
		// TODO Auto-generated method stub
		service.deleteById(id);
	}

	@Override
	public void aniadirEquipoFut(EquipoFutbolista equipo) {
		// TODO Auto-generated method stub
		service.save(equipo);
	}

	@Override
	public void actualizarEquipoFut(EquipoFutbolista equipo) {
		// TODO Auto-generated method stub
		service.save(equipo);
	}

	@Override
	public List<Futbolista> obtenerJugadoresPorIdClub(long idEquipo) {
		// TODO Auto-generated method stub


		return null;
	}

	@Override
	public List<Equipo> obtenerClubPorIdJugador(long idFutbolista) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipoFutbolista> obtenerHistoriaFutbolista(long idFutbolista) {
		// TODO Auto-generated method stub
		return service.findFutbolista(idFutbolista);
	}

	@Override
	public List<EquipoFutbolista> obtenerHistoriaClub(long idClub) {
		// TODO Auto-generated method stub
		return service.findEquipo(idClub);
	}



}
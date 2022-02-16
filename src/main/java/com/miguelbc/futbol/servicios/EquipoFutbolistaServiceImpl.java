package com.miguelbc.futbol.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.repositorio.Repos_Equipo_Futbolista;

public class EquipoFutbolistaServiceImpl implements EquipoFutbolistaServiceI{

	@Autowired
	private Repos_Equipo_Futbolista service;
	
	@Override
	public List<EquipoFutbolista> obtenerTodosEquiposFut() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public EquipoFutbolista obtenerEquipoPorTemporada(Date Temporada) {
		// TODO Auto-generated method stub
		final EquipoFutbolista ef = (EquipoFutbolista) service.findByTemporada(Temporada);		
		return ef;
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

}

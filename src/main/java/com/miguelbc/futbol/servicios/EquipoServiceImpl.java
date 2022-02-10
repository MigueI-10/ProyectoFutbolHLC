package com.miguelbc.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miguelbc.futbol.entidades.Equipo;

public class EquipoServiceImpl implements EquipoServiceI{

	private EquipoServiceI serviceI;
	
	@Override
	public List<Equipo> obtenerTodosEquipos() {
		// TODO Auto-generated method stub
		return serviceI.obtenerTodosEquipos();
	}

	@Override
	public Equipo obtenerEquipoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		final Equipo team = (Equipo) serviceI.obtenerEquipoPorNombre(nombre);
		return team;
	}

	@Override
	public List<Equipo> obtenerEquipoPorNombreOEstadio(String nombre, String estadio) {
		// TODO Auto-generated method stub
		return serviceI.obtenerEquipoPorNombreOEstadio(nombre, estadio);
	}

	@Override
	public List<Equipo> obtenerEquipoPorNombreYEstadio(String nombre, String estadio) {
		// TODO Auto-generated method stub
		return serviceI.obtenerEquipoPorNombreYEstadio(nombre, estadio);
	}

	@Override
	public void eliminarEquipoPorId(long id) {
		// TODO Auto-generated method stub
		serviceI.eliminarEquipoPorId(id);
	}

	@Override
	public void aniadirEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		serviceI.aniadirEquipo(equipo);
	}

	@Override
	public void actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		serviceI.actualizarEquipo(equipo);
	}
	
	
}

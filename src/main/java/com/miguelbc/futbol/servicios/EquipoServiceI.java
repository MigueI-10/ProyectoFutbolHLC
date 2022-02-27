package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.Equipo;



public interface EquipoServiceI {

	public List<Equipo> obtenerTodosEquipos();
	
	public Equipo obtenerEquipoPorId(final long id);

	public List<Equipo> obtenerEquipoPorNombre(final String nombre);

	public List<Equipo> obtenerEquipoPorEstadio(final String estadio);

	public void eliminarEquipoPorId(final long id);

	public void aniadirEquipo(final Equipo equipo);

	public void actualizarEquipo(final Equipo equipo);

}

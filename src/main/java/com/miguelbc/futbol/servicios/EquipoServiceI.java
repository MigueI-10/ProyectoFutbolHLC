package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.Equipo;



public interface EquipoServiceI {

	public List<Equipo> obtenerTodosEquipos();

	public Equipo obtenerEquipoPorNombre(final String nombre);

	public void eliminarEquipoPorId(final long id);

	public void aniadirEquipo(final Equipo equipo);

	public void actualizarEquipo(final Equipo equipo);
	
}

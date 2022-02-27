package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.entidades.Futbolista;


public interface EquipoFutbolistaServiceI {

	public List<EquipoFutbolista> obtenerTodosEquiposFut();

	public List<Futbolista> obtenerJugadoresPorNombreClub(final String nombre);

	public List<Equipo> obtenerClubPorDniJugador(final String dni);

	public void eliminarEquipoFutPorId(final long id);

	public void aniadirEquipoFut(final EquipoFutbolista equipo);

	public void actualizarEquipoFut(final EquipoFutbolista equipo);

}

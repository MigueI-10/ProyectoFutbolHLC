package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.entidades.Futbolista;


public interface EquipoFutbolistaServiceI {

	public List<EquipoFutbolista> obtenerTodosEquiposFut();

	public List<EquipoFutbolista> obtenerHistoriaFutbolista(final long idFutbolista);
	
	public List<EquipoFutbolista> obtenerHistoriaClub(final long idClub);

	public List<Futbolista> obtenerJugadoresPorIdClub(final long idEquipo);

	public List<Equipo> obtenerClubPorIdJugador(final long idFutbolista);

	public void eliminarEquipoFutPorId(final long id);

	public void aniadirEquipoFut(final EquipoFutbolista equipo);

	public void actualizarEquipoFut(final EquipoFutbolista equipo);

}

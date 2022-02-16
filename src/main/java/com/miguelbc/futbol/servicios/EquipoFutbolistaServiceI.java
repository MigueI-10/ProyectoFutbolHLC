package com.miguelbc.futbol.servicios;

import java.util.Date;
import java.util.List;

import com.miguelbc.futbol.entidades.EquipoFutbolista;

public interface EquipoFutbolistaServiceI {

	public List<EquipoFutbolista> obtenerTodosEquiposFut();

	public EquipoFutbolista obtenerEquipoPorTemporada(final Date Temporada);

	public void eliminarEquipoFutPorId(final long id);

	public void aniadirEquipoFut(final EquipoFutbolista equipo);

	public void actualizarEquipoFut(final EquipoFutbolista equipo);
	
}

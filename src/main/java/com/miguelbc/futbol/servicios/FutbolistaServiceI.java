package com.miguelbc.futbol.servicios;

import java.util.List;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.Futbolista;

public interface FutbolistaServiceI {

	public List<Futbolista> obtenerTodosFutbolistas();
	
	public Futbolista obtenerFutbolistaPorId(final long id);

	public List<Futbolista> obtenerFutbolistaPorNombre(final String nombre);

	public List<Futbolista> obtenerFutbolistaPorNif(final String nif);

	public void eliminarFutbolistaPorId(final long id);

	public void aniadirFutbolista(final Futbolista player);

	public void actualizarFutbolista(final Futbolista player);



}

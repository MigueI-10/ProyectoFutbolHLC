package com.miguelbc.futbol.servicios;

import java.util.Date;
import java.util.List;

import com.miguelbc.futbol.entidades.Futbolista;

public interface FutbolistaServiceI {

	public List<Futbolista> obtenerTodosFutbolistas();

	public Futbolista obtenerFutbolistaPorNombre(final String nombre);
	
	public Futbolista obtenerFutbolistaPorApellido(final String apellido);
	
	public Futbolista obtenerFutbolistaPorNif(final String nif);
	
	public Futbolista obtenerFutbolistaPorFecha(final Date fecha);

	public List<Futbolista> obtenerFutbolistaPorNombreONif(final String nombre, final String nif);

	public List<Futbolista> obtenerFutbolistaPorNombreYNif(final String nombre, final String nif);

	public void eliminarFutbolistaPorId(final long id);

	public void aniadirFutbolista(final Futbolista player);

	public void actualizarFutbolista(final Futbolista player);
	
	
	
}

package com.miguelbc.futbol.servicios;

import java.util.Date;
import java.util.List;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.Futbolista;

public class FutbolistaServiceImpl implements FutbolistaServiceI{

	private FutbolistaServiceI service;
	
	@Override
	public List<Futbolista> obtenerTodosFutbolistas() {
		// TODO Auto-generated method stub
		return service.obtenerTodosFutbolistas();
	}

	@Override
	public Futbolista obtenerFutbolistaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		final Futbolista pl = (Futbolista) service.obtenerFutbolistaPorNombre(nombre);
		return pl;
	}

	@Override
	public Futbolista obtenerFutbolistaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		final Futbolista pl = (Futbolista) service.obtenerFutbolistaPorApellido(apellido);
		return pl;
	}

	@Override
	public Futbolista obtenerFutbolistaPorNif(String nif) {
		// TODO Auto-generated method stub
		final Futbolista pl = (Futbolista) service.obtenerFutbolistaPorNif(nif);
		return pl;
	}

	@Override
	public Futbolista obtenerFutbolistaPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		final Futbolista pl = (Futbolista) service.obtenerFutbolistaPorFecha(fecha);
		return pl;
	}

	@Override
	public List<Futbolista> obtenerFutbolistaPorNombreONif(String nombre, String nif) {
		// TODO Auto-generated method stub
		return service.obtenerFutbolistaPorNombreONif(nombre, nif);
	}

	@Override
	public List<Futbolista> obtenerFutbolistaPorNombreYNif(String nombre, String nif) {
		// TODO Auto-generated method stub
		return service.obtenerFutbolistaPorNombreYNif(nombre, nif);
	}

	@Override
	public void eliminarFutbolistaPorId(long id) {
		// TODO Auto-generated method stub
		service.eliminarFutbolistaPorId(id);
	}

	@Override
	public void aniadirFutbolista(Futbolista player) {
		// TODO Auto-generated method stub
		service.aniadirFutbolista(player);
	}

	@Override
	public void actualizarFutbolista(Futbolista player) {
		// TODO Auto-generated method stub
		service.actualizarFutbolista(player);
	}

}

package com.miguelbc.futbol.servicios;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.Futbolista;
import com.miguelbc.futbol.repositorio.Repos_Futbolista;

@Service
public class FutbolistaServiceImpl implements FutbolistaServiceI{

	@Autowired
	private Repos_Futbolista service;
	
	@Override
	public List<Futbolista> obtenerTodosFutbolistas() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public Futbolista obtenerFutbolistaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		final Futbolista pl = (Futbolista) service.findByNombre(nombre);
		return pl;
	}


	@Override
	public Futbolista obtenerFutbolistaPorNif(String nif) {
		// TODO Auto-generated method stub
		final Futbolista pl = (Futbolista) service.findByNif(nif);
		return pl;
	}


	@Override
	public void eliminarFutbolistaPorId(long id) {
		// TODO Auto-generated method stub
		service.deleteById(id);
	}

	@Override
	public void aniadirFutbolista(Futbolista player) {
		// TODO Auto-generated method stub
		service.save(player);
	}

	@Override
	public void actualizarFutbolista(Futbolista player) {
		// TODO Auto-generated method stub
		service.save(player);
	}

}

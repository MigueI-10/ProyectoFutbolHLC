package com.miguelbc.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




	@Override
	public List<Futbolista> obtenerFutbolistaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return service.findByNombre(nombre);
	}

	@Override
	public List<Futbolista> obtenerFutbolistaPorNif(String nif) {
		// TODO Auto-generated method stub
		return service.findByNif(nif);
	}




	@Override
	public Futbolista obtenerFutbolistaPorId(long id) {
		// TODO Auto-generated method stub
		Futbolista f = service.findEquipoByID(id);
		return f;
	}

}

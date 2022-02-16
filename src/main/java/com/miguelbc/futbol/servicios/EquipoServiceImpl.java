package com.miguelbc.futbol.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.repositorio.Repos_Equipo;

@Service
public class EquipoServiceImpl implements EquipoServiceI{

	@Autowired
	private Repos_Equipo serviceI;
	
	@Override
	public List<Equipo> obtenerTodosEquipos() {
		// TODO Auto-generated method stub
		return serviceI.findAll();
	}

	@Override
	public Equipo obtenerEquipoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		final Equipo team = (Equipo) serviceI.findByNombre(nombre);
		return team;
	}


	@Override
	public void eliminarEquipoPorId(long id) {
		// TODO Auto-generated method stub
		serviceI.deleteById(id);
	}

	@Override
	public void aniadirEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		serviceI.save(equipo);
	}

	@Override
	public void actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		serviceI.save(equipo);
	}

	
	
}

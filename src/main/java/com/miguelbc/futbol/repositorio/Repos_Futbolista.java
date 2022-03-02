package com.miguelbc.futbol.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miguelbc.futbol.entidades.Futbolista;

public interface Repos_Futbolista extends JpaRepository<Futbolista, Long>{

	List<Futbolista> findByNombre(String nombre);

	List<Futbolista> findByApellido(String apellido);

	List <Futbolista> findByFechaNac(Date fechaNac);

	List <Futbolista> findByNacionalidad(String nacionalidad);

	List <Futbolista> findByNif(String nif);

	@Query(value = "SELECT * FROM futbolista WHERE id = ?", nativeQuery = true)
	 Futbolista findEquipoByID(long idJugador);


}

package com.miguelbc.futbol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFutbolApplication implements CommandLineRunner{

	/*@Autowired
	private EquipoServiceI service ;

	@Autowired
	private FutbolistaServiceI futb ;

	/*@Autowired
	private EquipoFutbolistaServiceI ef ;*/

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFutbolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("-------------------------");

		/*Equipo team = new Equipo();
		team.setNombre("Madagascar");
		team.setFechaCreacion(new Date("12/09/1901"));
		team.setEstadio("La Jungla");

		Futbolista f = new Futbolista();
		f.setNombre("Marcos");
		f.setNacionalidad("espanya");
		f.setNif("30123456D");
		f.setFechaNac(new Date("12/04/1995"));
		f.setApellido("Llorente");*/

		/*EquipoFutbolista eqf = new EquipoFutbolista();
		eqf.setEquipo(team);
		eqf.setFutbolista(f);
		eqf.setTemporada(new Date("19/06/2001"));*/


		//service.aniadirEquipo(team);
		//futb.aniadirFutbolista(f);
		//ef.aniadirEquipoFut(eqf);


		/*final List<Equipo> lista = service.obtenerTodosEquipos();
		if (!CollectionUtils.isEmpty(lista)) {
			for (var x : lista) {
				System.out.println(x.toString());
			}
		}*/




	}



}

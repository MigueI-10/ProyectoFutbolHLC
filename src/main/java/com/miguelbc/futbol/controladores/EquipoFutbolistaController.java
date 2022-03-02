package com.miguelbc.futbol.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.entidades.EquipoFutbolistaModelo;
import com.miguelbc.futbol.entidades.Futbolista;
import com.miguelbc.futbol.servicios.EquipoFutbolistaServiceI;
import com.miguelbc.futbol.servicios.EquipoServiceI;
import com.miguelbc.futbol.servicios.FutbolistaServiceI;

@Controller
public class EquipoFutbolistaController {

	@Autowired
	private EquipoFutbolistaServiceI serviceI;

	@Autowired
	private EquipoServiceI equipoServiceI;
	
	@Autowired
	private FutbolistaServiceI jugadorServiceI;

	private List<Equipo> listaEquipos = null;
	
	private List<Futbolista> listaJugadores = null;

	/*@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}*/


	@PostMapping("/actSearchTrayectoria")
	public String submitBuscarTrayectoriaForm(@ModelAttribute Futbolista searchedFutbolista, Model model) throws Exception {

		List<EquipoFutbolista> listaTrayectoria = new ArrayList<>();
		listaEquipos = new ArrayList<>();

		System.out.println(searchedFutbolista);

		final long idFutbolista = searchedFutbolista.getId();



		Equipo e = null;

		System.out.println(idFutbolista);
		//Comprueba que solo está relleno el campo de nombre.
		if (StringUtils.hasText(String.valueOf(idFutbolista))) {

			// Búsqueda por nombre
			listaTrayectoria = serviceI.obtenerHistoriaFutbolista(idFutbolista);

			//System.out.println(listaTrayectoria.size());

			for	(EquipoFutbolista d : listaTrayectoria) {
				System.out.println(d.getId() + " " + d.getTemporada());

				 e = d.getEquipo();
				 /*e.setAnyoCrea(d.getTemporada());

				anyo = d.get();*/

				 System.out.println("El equipo sacado de la lista es: " + e.getNombre());
					listaEquipos.add(e);

			}


		}
		// Carga de datos al modelo
		model.addAttribute("teamsListView", listaEquipos);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showTeams";
	}

	////////////////////BUSQUEDA DE EQUIPOS Y SUS JUGADORES INTERNOS
	
	
	@PostMapping("/actSearchJugadores")
	public String submitBuscarClubesForm(@ModelAttribute Equipo searchedEquipo, Model model) throws Exception {

		List<EquipoFutbolista> listaTrayectoria = new ArrayList<>();
		listaJugadores = new ArrayList<>();

		System.out.println(searchedEquipo);

		final long idClub = searchedEquipo.getId();

		Futbolista e = null;

		System.out.println(idClub);
		//Comprueba que solo está relleno el campo de nombre.
		if (StringUtils.hasText(String.valueOf(idClub))) {

			// Búsqueda por nombre
			listaTrayectoria = serviceI.obtenerHistoriaFutbolista(idClub);

			System.out.println(listaTrayectoria.size());

			for	(EquipoFutbolista d : listaTrayectoria) {
				System.out.println(d.getId() + " " + d.getTemporada());

				 e = d.getFutbolista();
				 /*e.setAnyoCrea(d.getTemporada());

				anyo = d.get();*/

				 System.out.println("El jugador sacado de la lista es: " + e.getNombre());
					listaJugadores.add(e);

			}


		}
		// Carga de datos al modelo
		model.addAttribute("playersListView", listaJugadores);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showPlayers";
	}


	@GetMapping("/showNombreEquipos")
	public String mostrarEquipos(Model model) {

		// Obtención de pacientes
		final List<Equipo> lista = equipoServiceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("EquiposListView", lista);
		

		return "redirect:index";
	}
	
	@GetMapping("/showNombreJugadores")
	public String mostrarJugadores(Model model) {

		// Obtención de pacientes
		final List<Futbolista> lista = jugadorServiceI.obtenerTodosFutbolistas();

		// Carga de datos al modelo
		model.addAttribute("FutbolistasListView", lista);
		

		return "redirect:index";
	}
	
	
	@GetMapping("/actAddPlayerClub")
	private String aniadirListas(Model model) {

		final List<Futbolista> lista = jugadorServiceI.obtenerTodosFutbolistas();
		final List<Equipo> equipos = equipoServiceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("FutbolistasListView", lista);
		model.addAttribute("EquiposListView", equipos);

		return "newTeamPlayer";

	}
	
	@PostMapping("/actAddFutClub")
	private String aniadirFutclub(@Valid @ModelAttribute EquipoFutbolistaModelo modelo, BindingResult result)
			throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(modelo.getTemporada());

		System.out.println(modelo.getEquipo());
		System.out.println(modelo.getFutbolista());
		System.out.println(date);
		
		Futbolista f = jugadorServiceI.obtenerFutbolistaPorId(Long.valueOf(modelo.getFutbolista()));
		Equipo e = equipoServiceI.obtenerEquipoPorId(Long.valueOf(Long.valueOf(modelo.getEquipo())));
		

		System.out.println(e.getEstadio());
		System.out.println(f.getNif());

		EquipoFutbolista ef = new EquipoFutbolista();
		ef.setEquipo(e);
		ef.setFutbolista(f);
		ef.setTemporada(date);

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			serviceI.aniadirEquipoFut(ef);
			
		}

		return "redirect:index";
	}





}

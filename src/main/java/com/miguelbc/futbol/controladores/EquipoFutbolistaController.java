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
import com.miguelbc.futbol.entidades.FutbolistaModelo;
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


	/**
	 * Metodo que sirve para ver la trayectoria de un futbolista
	 * @param searchedFutbolista a buscar para encontrar su trayectoria
	 * @param model
	 * @return la vista de listar jugadores para ver los demas jugadores
	 * @throws Exception
	 */
	@PostMapping("/actSearchTrayectoria")
	public String submitBuscarTrayectoriaForm(@ModelAttribute FutbolistaModelo searchedFutbolista, Model model) throws Exception {

		List<EquipoFutbolista> listaTrayectoria = new ArrayList<>();
		listaEquipos = new ArrayList<>();

		System.out.println(searchedFutbolista);

		//Guardo la id
		final long idFutbolista = searchedFutbolista.getId();

		Equipo e = null;

		System.out.println(idFutbolista);


		//Comprueba que solo está relleno el campo de nombre.
		if (StringUtils.hasText(String.valueOf(idFutbolista))) {

			// Búsqueda por nombre
			listaTrayectoria = serviceI.obtenerHistoriaFutbolista(idFutbolista);

			System.out.println("El tamaño de la lista es: " + listaTrayectoria.size());

			//Recorro la lista de la trayectoria y voy volcando los datos
			for	(EquipoFutbolista d : listaTrayectoria) {
				System.out.println(d.getId() + " " + d.getTemporada());

				 e = d.getEquipo();

				 e.setFechaCreacion(d.getTemporada());

				 //Imprimo para ver todo correcto
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


	/***
	 * Metodo que sirve para ver los jugadores de un club
	 * @param searchedEquipo equipo a buscar en la base de datos
	 * @param model
	 * @return retorna la vista de equipos para ver los equipos
	 * @throws Exception
	 */
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
			listaTrayectoria = serviceI.obtenerHistoriaClub(idClub);

			System.out.println(listaTrayectoria.size());

			for	(EquipoFutbolista d : listaTrayectoria) {
				System.out.println(d.getId() + " " + d.getTemporada());

				 e = d.getFutbolista();

				 e.setFechaNac(d.getTemporada());

				 System.out.println("El jugador sacado de la lista es: " + e.getNombre());
					listaJugadores.add(e);

			}


		}
		// Carga de datos al modelo
		model.addAttribute("playersListView", listaJugadores);
		model.addAttribute("btnDropFutbolistaEnabled", Boolean.FALSE);

		return "showPlayers";
	}


	/***
	 * Metodo que pasa las dos listas de jugadores y equipos a la vista de insercion de la tabla
	 * @param model
	 * @return retorna la vista de inserción de la tabla n:m
	 */
	@GetMapping("/actAddPlayerClub")
	private String aniadirListas(Model model) {

		final List<Futbolista> lista = jugadorServiceI.obtenerTodosFutbolistas();
		final List<Equipo> equipos = equipoServiceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("FutbolistasListView", lista);
		model.addAttribute("EquiposListView", equipos);

		return "newTeamPlayer";

	}

	/**
	 * Metodo que inserta en la tabla n:M, un jugador y su equipo
	 * @param modelo objeto equipoFutbolista para insertar en la tabla
	 * @param result
	 * @return retorna el index para realizar más acciones
	 * @throws Exception
	 */
	@PostMapping("/actAddFutClub")
	private String aniadirFutclub(@Valid @ModelAttribute EquipoFutbolistaModelo modelo, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {
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


			// Se añade el nuevo coche
			serviceI.aniadirEquipoFut(ef);

		}

		return "redirect:index";
	}





}

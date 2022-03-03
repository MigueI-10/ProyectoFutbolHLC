package com.miguelbc.futbol.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miguelbc.futbol.servicios.EquipoServiceI;
import com.miguelbc.futbol.servicios.FutbolistaServiceI;

@Controller
@RequestMapping("*")
public class SystemController {

	@Autowired
	private EquipoServiceI equipoServiceI;

	@Autowired
	private FutbolistaServiceI jugadorServiceI;

	//Capta cualquier solicitud
	@GetMapping
	public String showIndex() {
		return "index";
	}

	/////EQUIPO//////////

	/***
	 * Metodo que nos lleva a la lista de equipos
	 * @return el metodo del controlador al que va
	 */

	@GetMapping("/showAll")
	public String redirectToShowAll() {
		return "redirect:showTeamViews";
	}

	/***
	 *   Metodo que nos lleva a la búsqueda de equipos
	 * @return el metodo del controlador al que va
	 */

	//Redirecciona a la plantilla de búsqueda
	@GetMapping("/searchTeamByView")
	public String redirectToTeamSearchByTemplate() {

		return "searchTeamBy";
	}

	/***
	 * Metodo que nos lleva a insertar un equipo nuevo
	 * @return el metodo del controlador al que va
	 */
	//Redirecciona a la plantilla de inserción
	@GetMapping("/newTeamView")
	public String redirectToNewTeam() {
		return "newTeam";
	}

	//////////JUGADOR////////////////

	/***
	 * Metodo que nos lleva a la lista de jugadores
	 * @return el metodo del controlador al que va
	 */

		@GetMapping("/showAllPlayers")
		public String redirectToShowAllPlayer() {
			return "redirect:showPlayerViews";
		}

		/***
		 * Metodo que nos lleva a la búsqueda de jugador
		 * @return el metodo del controlador al que va
		 */
		//Redirecciona a la plantilla de búsqueda
		@GetMapping("/searchPlayerByView")
		public String redirectToPlayerSearchByTemplate() {
			return "searchPlayerBy";
		}
		/***
		 * Metodo que nos lleva a insertar un jugador nuevo a la base de datos
		 * @return el metodo del controlador al que va
		 */

		//Redirecciona a la plantilla de inserción
		@GetMapping("/newPlayerView")
		public String redirectToNewPlayer() {
			return "newPlayer";
		}

		//////////EQUIPO-FUTBOLISTA////////////////

		/***
		 * Metodo que llama a la vista de añadir de la tabla equipo futbolista
		 * @return el metodo del controlador al que va
		 */
			//Redirecciona a la plantilla de insercción
			@GetMapping("/newTeamPlayerView")
			public String redirectToNewTeamPlayer() {
				return "redirect:actAddPlayerClub";
			}

			/***
			 * Metodo que sirve para ver la trayectoria de un jugador
			 * @param model modelo para añadir la lista a usar
			 * @return el metodo del controlador al que va
			 */
			@GetMapping("/showPlayerHist")
			public String redirectToHistoryPlayer(Model model) {
				model.addAttribute("FutbolistasListView", jugadorServiceI.obtenerTodosFutbolistas());
				return "showHisFut";
			}

			/***
			 * Metodo que sirve para ver los jugadores de un equipo
			 * @param model modelo que se usa para mandar la lista
			 * @return el metodo del controlador al que va
			 */
			@GetMapping("/showClubHist")
			public String redirectToHistoryClub(Model model) {
				model.addAttribute("EquiposListView", equipoServiceI.obtenerTodosEquipos());
				return "showHisClub";
			}

}

package com.miguelbc.futbol.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class SystemController {


	//Capta cualquier solicitud
	@GetMapping
	public String showIndex() {
		return "index";
	}

	/////EQUIPO//////////

	//Redirecciona al controlador de gestión de coches
	@GetMapping("/showAll")
	public String redirectToShowAll() {
		return "redirect:showTeamViews";
	}

	//Redirecciona a la plantilla de búsqueda
	@GetMapping("/searchTeamByView")
	public String redirectToTeamSearchByTemplate() {

		return "searchTeamBy";
	}

	//Redirecciona a la plantilla de insercción
	@GetMapping("/newTeamView")
	public String redirectToNewTeam() {
		return "newTeam";
	}

	//////////JUGADOR////////////////

	//Redirecciona al controlador de gestión de coches
		@GetMapping("/showAllPlayers")
		public String redirectToShowAllPlayer() {
			return "redirect:showPlayerViews";
		}

		//Redirecciona a la plantilla de búsqueda
		@GetMapping("/searchPlayerByView")
		public String redirectToPlayerSearchByTemplate() {
			return "searchPlayerBy";
		}

		//Redirecciona a la plantilla de insercción
		@GetMapping("/newPlayerView")
		public String redirectToNewPlayer() {
			return "newPlayer";
		}

		//////////EQUIPO-FUTBOLISTA////////////////


			//Redirecciona a la plantilla de insercción
			@GetMapping("/newTeamPlayerView")
			public String redirectToNewTeamPlayer() {
				return "newTeamPlayer";
			}



}

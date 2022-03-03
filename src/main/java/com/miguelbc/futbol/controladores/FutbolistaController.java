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
import org.springframework.web.bind.annotation.RequestParam;

import com.miguelbc.futbol.entidades.Futbolista;
import com.miguelbc.futbol.entidades.FutbolistaModelo;
import com.miguelbc.futbol.servicios.FutbolistaServiceI;

@Controller
public class FutbolistaController {

	@Autowired
	private FutbolistaServiceI serviceI;

	private long idUse = 0L;


	/*@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}*/


	/***
	 * Metodo que sirve para mostrar todos los jugadores
	 * @param model
	 * @return la vista de todos los jugadores
	 */
	@GetMapping("/showPlayerViews")
	public String mostrarJugadores(Model model) {

		// Obtención de vehículos
		final List<Futbolista> lista = serviceI.obtenerTodosFutbolistas();

		// Carga de datos al modelo
		model.addAttribute("playersListView", lista);
		model.addAttribute("btnDropPlayerEnabled", Boolean.FALSE);

		return "showPlayers";
	}

	/***
	 * Metodo que recoge los datos de un futbolista con su id
	 * @param playerId del jugador a modificar
	 * @param model
	 * @return la vista para poder actualizar los datos
	 */
	 @GetMapping("/editPlayersView")
		public String recogerJugador(String playerId, Model model) {

			// Obtención de pacientes
		// Obtención de pacientes

		  idUse = Long.valueOf(playerId);

		  Futbolista p = serviceI.obtenerFutbolistaPorId(Long.valueOf(playerId));

		  model.addAttribute("id", p.getId());
		//Carga de datos al modelo
		  model.addAttribute("nif", p.getNif());
		  model.addAttribute("nombre", p.getNombre());
		  model.addAttribute("apellido", p.getApellido());
		  model.addAttribute("nacionalidad", p.getNacionalidad());
		  model.addAttribute("fechaNac", p.getFechaNac());

			return "editPlayer";
		}

	 /***
	  * Metodo que sirve para actualizar un jugador
	  * @param FutbolistaModelo objeto con los datos a modificar
	  * @param result
	  * @return retorna la vista de todos los jugadores para ver los cambios realizados
	  * @throws Exception por si hay fallo al parsear una fecha
	  */
		@PostMapping("/actEditPlayer")
		public String editarFutbolista(@Valid @ModelAttribute FutbolistaModelo FutbolistaModelo, BindingResult result) throws Exception {

			if (result.hasErrors()) {
				throw new Exception("Parámetros de matriculación erróneos");
			}
			else {

				System.out.println(FutbolistaModelo.toString());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


				Date date = formatter.parse(FutbolistaModelo.getFechaNac());

				Futbolista f = serviceI.obtenerFutbolistaPorId(FutbolistaModelo.getId());

				f.setNombre(FutbolistaModelo.getNombre());
				f.setApellido(FutbolistaModelo.getApellido());
				f.setFechaNac(date);
				f.setNacionalidad(FutbolistaModelo.getNacionalidad());
				f.setNif(FutbolistaModelo.getNif());

				serviceI.actualizarFutbolista(f);

			}

			return "redirect:showPlayerViews";
		}



	/***
	 * Metodo para eliminar un jugador
	 * @param playerId del jugador a borrar
	 * @param model
	 * @return la lista de todos los jugadores
	 */
	@PostMapping("/actDropPlayer")
	public String eliminarJugador(@RequestParam Long playerId, Model model) {

		System.out.println(playerId);
		// Eliminación de vehículo
		serviceI.eliminarFutbolistaPorId(Long.valueOf(playerId));

		return "redirect:showPlayerViews";

	}

	/***
	 * Metodo que sirve para buscar un jugador concreto por nombre o nif
	 * @param searchedPlayer
	 * @param model
	 * @return la vista con los jugadores encontrados
	 * @throws Exception
	 */
	@PostMapping("/actSearchPlayer")
	public String submitBuscarPlayerForm(@ModelAttribute Futbolista searchedPlayer, Model model) throws Exception {

		List<Futbolista> lista = new ArrayList<>();

		System.out.println(searchedPlayer.getNombre());

		final String jugadorNombre = searchedPlayer.getNombre();
		final String jugadorNif = searchedPlayer.getNif();


		System.out.println(jugadorNombre);
		if (StringUtils.hasText(jugadorNombre)) {

			// Búsqueda por matrícula
			lista = serviceI.obtenerFutbolistaPorNombre(jugadorNombre);


		} else if (!StringUtils.hasText(jugadorNombre)
				&& (StringUtils.hasText(jugadorNif))) {

			// Búsqueda por marca o modelo
			lista = serviceI.obtenerFutbolistaPorNif(jugadorNif);

		}  else {
			throw new Exception("Parámetros de búsquieda erróneos.");
		}

		if(!lista.isEmpty()) {
			// Carga de datos al modelo
			model.addAttribute("playersListView", lista);
			model.addAttribute("btnDropPlayerEnabled", Boolean.FALSE);
		}
		else {
			throw new Exception("No se encontró el jugador");
		}

		return "showPlayers";

	}

	/***
	 * Metodo que inserta un jugador a la base de datos
	 * @param player a insertar
	 * @param result
	 * @return la lista de jugadores para ver la insercion
	 * @throws Exception por si salta a la hora de parsear una fecha
	 */

	@PostMapping("/actAddPlayer")
	private String aniadirJugador(@Valid @ModelAttribute FutbolistaModelo player, BindingResult result) throws Exception {


		System.out.println(player.getFechaNac());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


		Date date = formatter.parse(player.getFechaNac());

		Futbolista f = new Futbolista();

		f.setNombre(player.getNombre());
		f.setApellido(player.getApellido());
		f.setFechaNac(date);
		f.setNacionalidad(player.getNacionalidad());
		f.setNif(player.getNif());

		f.toString();

		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			serviceI.aniadirFutbolista(f);
		}

		return "redirect:showPlayerViews";


	}

}

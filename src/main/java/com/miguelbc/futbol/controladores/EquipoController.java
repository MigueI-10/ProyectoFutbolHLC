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

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.entidades.EquipoModelo;
import com.miguelbc.futbol.servicios.EquipoServiceI;
//import com.miguelbc.futbol.servicios.EquipoServiceI;

@Controller
public class EquipoController {

	@Autowired
	private EquipoServiceI serviceI;

	/*@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}*/

	private long idUse = 0L;


	/***
	 * Metodo que muestra todos los equipos disponibles de la base de datos
	 * @param model
	 * @return Retorna la vista a la que tiene que ir con la lista de equipos
	 */
	@GetMapping("/showTeamViews")
	public String mostrarEquipos(Model model) {


		// Obtención de equipos
		final List<Equipo> lista = serviceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("teamsListView", lista);
		model.addAttribute("btnDropTeamEnabled", Boolean.FALSE);

		return "showTeams";
	}


	/***
	 * Metodo que sirve para recoger los datos de un Equipo
	 * @param teamId la id del equipo a tratar
	 * @param model
	 * @return Retorna la vista para modificar los datos
	 */
	  @GetMapping("/editTeamsView")
		public String recogerEquipo(String teamId, Model model) {

			// Obtención de equipos

		  idUse = Long.valueOf(teamId);
					Equipo p = serviceI.obtenerEquipoPorId(Long.valueOf(teamId));

					// Carga de datos al modelo
					model.addAttribute("id", p.getId());
					model.addAttribute("nombre", p.getNombre());
					model.addAttribute("estadio", p.getEstadio());
					model.addAttribute("fechaCreacion", p.getFechaCreacion());

			return "editTeam";
		}

	   /***
	   * Metodo que actualiza los datos de un equipo en concreto
	   * @param EquipoModelo objeto con sus datos a modificar
	   * @param result
	   * @return Retorna a la vista de listar de equipos
	   * @throws Exception para controlar las fechas a la hora de insertar
	   */
		@PostMapping("/actEditTeam")
		public String editarEquipo(@Valid @ModelAttribute EquipoModelo EquipoModelo, BindingResult result) throws Exception {

			//Comprueba si hay errores a la hora de editar
			if (result.hasErrors()) {
				throw new Exception("Parámetros de matriculación erróneos");
			}
			else {

				//Sacamos el equipo y sus datos
				Equipo e = serviceI.obtenerEquipoPorId(EquipoModelo.getId());

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = formatter.parse(EquipoModelo.getFechaCreacion());

				e.setNombre(EquipoModelo.getNombre());
				e.setEstadio(EquipoModelo.getEstadio());
				e.setFechaCreacion(date);

				serviceI.actualizarEquipo(e);
			}

			return "redirect:showTeamViews";
		}

	/***
	 * Metodo que elimina un equipo de la base de datos
	 * @param teamId la id del equipo a borrar
	 * @param model
	 * @return Retorna la vista de la lista de equipos
	 */
	@PostMapping("/actDropTeam")
	public String eliminarEquipo(@RequestParam String teamId, Model model) {

		// Eliminación de equipo
		serviceI.eliminarEquipoPorId(Long.valueOf(teamId));

		return "redirect:showTeamViews";

	}

	/***
	 * Metodo que sirve para buscar un equipo por su nombre o por su estadio
	 * @param searchedTeam objeto con los datos a buscar por campos
	 * @param model
	 * @return Retorna una vista y la lista de los equipos que coinciden con los parámtros introducidos
	 * @throws Exception
	 */
	@PostMapping("/actSearchTeam")
	public String submitBuscarEquipoForm(@ModelAttribute Equipo searchedTeam, Model model) throws Exception {

		List<Equipo> lista = new ArrayList<>();

		//Sacamos los parámetros de búsqueda
		final String equipoNombre = searchedTeam.getNombre();
		final String equipoEstadio = searchedTeam.getEstadio();

		System.out.println(equipoNombre);
		System.out.println(equipoEstadio);

		if (StringUtils.hasText(equipoNombre)) {

			// Búsqueda por nombre
			lista = serviceI.obtenerEquipoPorNombre(equipoNombre);


		} else if (!StringUtils.hasText(equipoNombre)
				&& (StringUtils.hasText(equipoEstadio))) {

			// Búsqueda por estadio
			lista = serviceI.obtenerEquipoPorEstadio(equipoEstadio);

		}  else {
			throw new Exception("Parámetros de búsquieda erróneos.");
		}

		if(!lista.isEmpty()){
			// Carga de datos al modelo
			model.addAttribute("teamsListView", lista);
			model.addAttribute("btnUpdateTeamEnabled", Boolean.FALSE);
			model.addAttribute("btnDropTeamEnabled", Boolean.FALSE);

		}  else {
			throw new Exception("Equipo no encontrado.");
		}


		return "showTeams";

	}

	/***
	 * Metodo que sirve para añadir un equipo a la base de datos
	 * @param newEquipoModelo objeto donde recogemos los datos para insertar el equipo
	 * @param result
	 * @return Retorna la vista de listar todos los equipos
	 * @throws Exception para controlar las fechas
	 */

	@PostMapping("/actAddTeam")
	private String aniadirEquipo(@Valid @ModelAttribute EquipoModelo newEquipoModelo, BindingResult result) throws Exception {

		//Sacamos los datos en una clase Equipo Modelo para parsear la fecha

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


		Date date = formatter.parse(newEquipoModelo.getFechaCreacion());

		Equipo e = new Equipo();

		//Volcamos los datos en el nuevo objeto
		e.setNombre(newEquipoModelo.getNombre());
		e.setEstadio(newEquipoModelo.getEstadio());
		e.setFechaCreacion(date);


		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo equipo
			serviceI.aniadirEquipo(e);
		}

		return "redirect:showTeams";
	}



}

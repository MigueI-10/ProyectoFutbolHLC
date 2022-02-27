package com.miguelbc.futbol.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miguelbc.futbol.entidades.EquipoFutbolista;
import com.miguelbc.futbol.servicios.EquipoFutbolistaServiceI;

@Controller
public class EquipoFutbolistaController {

	@Autowired
	private EquipoFutbolistaServiceI serviceI;

	/*@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}*/


	  @GetMapping("/showTeamPlayerViews")
	public String mostrarEquiposFutbolistas(Model model) {

		// Obtención de vehículos
		final List<EquipoFutbolista> lista = serviceI.obtenerTodosEquiposFut();

		// Carga de datos al modelo
		model.addAttribute("teamPlayersListView", lista);
		model.addAttribute("btnDropTeamPlayerEnabled", Boolean.FALSE);

		return "showTeamPlayers";
	}

	@PostMapping("/actDropTeamPlayer")
	public String eliminarEquipoFutbolista(@RequestParam String teamId, Model model) {

		// Eliminación de vehículo
		serviceI.eliminarEquipoFutPorId(Long.valueOf(teamId));

		return "redirect:showTeamPlayers";

	}

	@PostMapping("/actSearchTeamPlayer")
	public String submitBuscarEquipoForm(@ModelAttribute EquipoFutbolista searchedTeam, Model model) throws Exception {

		/*ArrayList<Equipo> lista = new ArrayList<Equipo>();



		final String equipoNombre = searchedTeam.getNombre();

		final Equipo e = serviceI.obtenerEquipoPorNombre(equipoNombre);

		System.out.println(equipoNombre);
		System.out.println(e.toString());

		if (StringUtils.hasText(equipoNombre)) {

			// Búsqueda por matrícula


			if (e != null) {
				lista.add(e);
			}
		}  else {
			throw new Exception("Parámetros de búsquieda erróneos.");
		}

		// Carga de datos al modelo
		model.addAttribute("teamListView", lista);
		model.addAttribute("btnDropTeamEnabled", Boolean.TRUE);*/

		return "showTeamPlayers";

	}

	@PostMapping("/actAddTeamPlayer")
	private String aniadirEquipoFutbolista(@Valid @ModelAttribute EquipoFutbolista newEquipoModelo, BindingResult result) throws Exception {

		//System.out.println(newEquipoModelo.getFechaCreacion());

		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


		Date date = formatter.parse(newEquipoModelo.getFechaCreacion());

		Equipo e = new Equipo();

		e.setNombre(newEquipoModelo.getNombre());
		e.setEstadio(newEquipoModelo.getEstadio());
		e.setFechaCreacion(date);


		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			serviceI.aniadirEquipoFut(null)
		}*/

		return "redirect:showTeamPlayers";
	}



}

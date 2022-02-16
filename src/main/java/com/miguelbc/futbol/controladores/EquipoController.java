package com.miguelbc.futbol.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.miguelbc.futbol.entidades.Equipo;
import com.miguelbc.futbol.servicios.EquipoServiceI;

@Controller
public class EquipoController {

	@Autowired
	private EquipoServiceI serviceI;
	
	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "hello world";
	}
	
	
	  @GetMapping("/showTeamViews")
	public String mostrarEquipos(Model model) {

		// Obtención de vehículos
		final List<Equipo> lista = serviceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("carsListView", lista);
		model.addAttribute("btnDropCarEnabled", Boolean.FALSE);

		return "showTeams";
	}

	@PostMapping("/actDropTeam")
	public String eliminarEquipo(@RequestParam String teamId, Model model) {

		// Eliminación de vehículo
		serviceI.eliminarEquipoPorId(Long.valueOf(teamId));

		return "redirect:showTeamView";

	}

	@PostMapping("/actSearchCar")
	public String submitBuscarCocheForm(@ModelAttribute Equipo searchedTeam, Model model) throws Exception {

		List<Equipo> lista = new ArrayList<Equipo>();
		
		System.out.println(searchedTeam.getNombre());

		final String equipoNombre = searchedTeam.getNombre();


		System.out.println(equipoNombre);
		if (StringUtils.hasText(equipoNombre)) {

			// Búsqueda por matrícula
			final Equipo e = serviceI.obtenerEquipoPorNombre(equipoNombre);

			if (e != null) {
				lista.add(e);
			}
		}  else {
			throw new Exception("Parámetros de búsquieda erróneos.");
		}

		// Carga de datos al modelo
		model.addAttribute("teamListView", lista);
		model.addAttribute("btnDropTeamEnabled", Boolean.TRUE);

		return "showCars";

	}

	@PostMapping("/actAddCar")
	private String aniadirCoche(@Valid @ModelAttribute Equipo newTeam, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new Exception("Parámetros de matriculación erróneos");
		} else {

			// Se añade el nuevo coche
			serviceI.aniadirEquipo(newTeam);
		}

		return "redirect:showCarsView";
	}
	
	
	
}

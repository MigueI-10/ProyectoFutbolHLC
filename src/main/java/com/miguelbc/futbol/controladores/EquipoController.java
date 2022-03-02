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


	  @GetMapping("/showTeamViews")
	public String mostrarEquipos(Model model) {

		// Obtención de vehículos
		final List<Equipo> lista = serviceI.obtenerTodosEquipos();

		// Carga de datos al modelo
		model.addAttribute("teamsListView", lista);
		model.addAttribute("btnDropTeamEnabled", Boolean.FALSE);

		return "showTeams";
	}


	  @GetMapping("/editTeamsView")
		public String recogerEquipo(String teamId, Model model) {

			// Obtención de pacientes
		// Obtención de pacientes

		  idUse = Long.valueOf(teamId);
					Equipo p = serviceI.obtenerEquipoPorId(Long.valueOf(teamId));

					// Carga de datos al modelo
					model.addAttribute("nombre", p.getNombre());
					model.addAttribute("estadio", p.getEstadio());
					model.addAttribute("fechaCreacion", p.getFechaCreacion());

			return "editTeam";
		}

		@GetMapping("/actEditTeam")
		public String editarEquipo(@Valid @ModelAttribute EquipoModelo EquipoModelo, BindingResult result) throws Exception {

			Equipo e = new Equipo();

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(EquipoModelo.getFechaCreacion());

			e.setNombre(EquipoModelo.getNombre());
			e.setEstadio(EquipoModelo.getEstadio());
			e.setFechaCreacion(date);


			if (result.hasErrors()) {
				throw new Exception("Parámetros de matriculación erróneos");
			}
			else {

				serviceI.eliminarEquipoPorId(idUse);
				serviceI.actualizarEquipo(e);

			}
			// Obtención de pacientes


			return "redirect:showTeams";
		}


	@PostMapping("/actDropTeam")
	public String eliminarEquipo(@RequestParam String teamId, Model model) {

		// Eliminación de vehículo
		serviceI.eliminarEquipoPorId(Long.valueOf(teamId));

		return "redirect:showTeams";

	}

	@PostMapping("/actSearchTeam")
	public String submitBuscarEquipoForm(@ModelAttribute Equipo searchedTeam, Model model) throws Exception {

		List<Equipo> lista = new ArrayList<>();

		final String equipoNombre = searchedTeam.getNombre();
		final String equipoEstadio = searchedTeam.getEstadio();

		System.out.println(equipoNombre);
		System.out.println(equipoEstadio);

		if (StringUtils.hasText(equipoNombre)) {

			// Búsqueda por matrícula
			lista = serviceI.obtenerEquipoPorNombre(equipoNombre);


		} else if (!StringUtils.hasText(equipoNombre)
				&& (StringUtils.hasText(equipoEstadio))) {

			// Búsqueda por marca o modelo
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


	@PostMapping("/actAddTeam")
	private String aniadirEquipo(@Valid @ModelAttribute EquipoModelo newEquipoModelo, BindingResult result) throws Exception {

		//System.out.println(newEquipoModelo.getFechaCreacion());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


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
			serviceI.aniadirEquipo(e);
		}

		return "redirect:showTeams";
	}



}

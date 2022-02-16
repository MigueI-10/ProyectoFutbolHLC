package com.miguelbc.futbol.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@ControllerAdvice
public class EquipoControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest req, Exception e, Model model) {

		// Respuesta.
		model.addAttribute("errorMsg", e.getMessage());

		return "error";
	}

}

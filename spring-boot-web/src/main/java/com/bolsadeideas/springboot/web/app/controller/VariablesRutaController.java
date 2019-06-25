package com.bolsadeideas.springboot.web.app.controller;

/**
 ************************************************************************
 ********************  Progreso del desarrollo	*************************
 ************************************************************************
 * - descripcion: Anotacion @PathVariable								*
 * - numero: 23															*
 ************************************************************************ 
 * - descripcion: Obtener varios parametros de la ruta con @PathVariable*
 * - numero: 24															*
 ************************************************************************ 
**/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablesRutaController {
	/**
	 * 
	 * @return 24
	 */ 
	@GetMapping("/")
	public String index(Model model) { 
		model.addAttribute("titulo","Enviar parametros");
		return "variables/index";
	}
	 
	/**
	 * 
	 * @return 23
	 */ 
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto,Model model) { 
		model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado","El texto enviado en la ruta es: " + texto);
		return "variables/ver";
	}
	/**
	 * 
	 * @return 24
	 */ 
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) { 
		model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado","El texto enviado en la ruta es: " + texto
				+ " y el numero enviado en el path es: " + numero);
		return "variables/ver";
	}
}

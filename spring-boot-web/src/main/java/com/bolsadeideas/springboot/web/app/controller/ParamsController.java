package com.bolsadeideas.springboot.web.app.controller;

/**
 ************************************************************************
 ********************  Progreso del desarrollo	*************************
 ************************************************************************
 * - descripcion: Anotacion @RequestParam								*
 * - numero: 21															*
 ************************************************************************
 * - descripcion: Obtener varios parametros de la URL con @RequestParam	*
 * - numero: 22															*
 ************************************************************************
**/

import javax.servlet.http.HttpServletRequest; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	/**
	 * 
	 * @return 21
	 */
	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	/**
	 * 
	 * @return 21
	 */
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "algùn valor..") String texto,
			Model model) {
		model.addAttribute("resultado", "El texto enviado es :".concat(texto));
		return "params/ver";
	}
	/**
	 * 
	 * @return 22
	 */
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'");
		return "params/ver";
	}
	/**
	 * 
	 * @return 22
	 */
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			numero = 0;
		}

		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'");
		return "params/ver";
	}
}

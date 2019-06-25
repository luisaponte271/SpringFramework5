package com.bolsadeideas.springboot.web.app.controller;

/**
 ************************************************************************
 ********************  Progreso del desarrollo	*************************
 ************************************************************************
 * - descripcion: Creando el controlador y la vista						*
 * - numero: 12															*
 ************************************************************************
 * - descripcion: Pasar datos a la vista								*
 * - numero: 14															*
 ************************************************************************
 * - descripcion: Anotaciòn @RequestMapping sobre el controlador		*
 * - numero: 15															*
 ************************************************************************
 * - descripcion: El objecto Model										*
 * - numero: 17															*
 ************************************************************************
 * - descripcion: Directiva if de thymeleaf								*
 * - numero: 18														    *
 ************************************************************************
 * - descripcion: Directiva each(foreach) de thymeleaf					*
 * - numero: 19													    	*
 ************************************************************************
 * - descripcion: Anotaciòn @ModelAttribute								*
 * - numero: 20													    	*
 ************************************************************************
 * - descripcion: Agregando recursos estaticos y estilos CSS			*
 *  	personalizados													*
 * - numero: 25													    	*
 ************************************************************************
 * - descripcion: Agregando otros archivos properties					*
 * 		personalizados para los textos									*
 * - numero: 27													    	*
 ************************************************************************
 **/
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.ArrayList;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
 

import com.bolsadeideas.springboot.web.app.models.Usuario;
 
/** 
 * @return 12
 */
@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	/** 
	 * @return 12
	 */
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	//@GetMapping(value="/index")
	@GetMapping({"/index","/","/home"}) 
	public String index(ModelMap model) { 
		/**
		 * Usando Model, ModelMap, Map, ModelAndView
		 * cumplen la misma función.
		 * @return 14
		 */
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	/** 
	 * @return 17, 18
	 */ 
	@RequestMapping("/perfil")
	public String perfil(Model model) { 
		Usuario usuario = new Usuario();
		usuario.setNombre("Luis");
		usuario.setApellido("Aponte");
		usuario.setEmail("luisaponte271@gmail.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	/** 
	 * @return 18, 19
	 */ 
	@RequestMapping("/listar")
	public String listar(Model model) {  

		model.addAttribute("titulo",textoListar);
		return "listar";
	}
	/** 
	 * @return 20
	 */ 
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() { 
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Luis","Aponte","luisaponte271@gmail.com"),
				new Usuario("Jean carlo","Aponte","jeancarlos271@gmail.com"),
				new Usuario("Alexander","Aponte","alexander271@gmail.com"),
				new Usuario("Benito","ramirex","benito.ramiro@gmail.com"));
  
		return usuarios;
	}
}

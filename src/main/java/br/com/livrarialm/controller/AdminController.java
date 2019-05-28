package br.com.livrarialm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livrarialm.model.Usuario;

@Controller
@RequestMapping("/administrador")
public class AdminController {
	
	@RequestMapping("/")
	public ModelAndView admin(Usuario usuario) {
		ModelAndView mv = new ModelAndView("administrador/portal");
		mv.addObject("usuario", usuario);
		return mv;
	}

}

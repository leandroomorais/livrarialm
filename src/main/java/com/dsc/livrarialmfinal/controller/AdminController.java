package com.dsc.livrarialmfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dsc.livrarialmfinal.model.User;


@Controller
@RequestMapping("/administrador")
public class AdminController {
	
	@RequestMapping("/")
	public ModelAndView admin(User usuario) {
		ModelAndView mv = new ModelAndView("administrador/portal");
		mv.addObject("usuario", usuario);
		return mv;
	}

}

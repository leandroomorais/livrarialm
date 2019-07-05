package com.dsc.livrarialmfinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dsc.livrarialmfinal.model.User;
import com.dsc.livrarialmfinal.service.UserService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UserService usuarioService;

	@GetMapping("/add")
	public ModelAndView add(User usuario) {
		ModelAndView mv = new ModelAndView("/usuario/formuser");
		mv.addObject("usuario", usuario);
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid User usuario, BindingResult result) {

		if (result.hasErrors()) {
			return add(usuario).addObject("msg", "Erro ao cadastrar");
		}
		
		usuarioService.save(usuario);
		ModelAndView mv = add(usuario);
		mv.addObject("msg", "Cadastro realizado com sucesso!");
		return mv;
	}

	@GetMapping("/lista")
	private ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("usuario/list");
		mv.addObject("usuarios", usuarioService.listaAll());
		return mv;
	}

}

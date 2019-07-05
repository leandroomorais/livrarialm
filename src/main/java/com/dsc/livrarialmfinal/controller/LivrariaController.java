package com.dsc.livrarialmfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dsc.livrarialmfinal.model.ItemPedido;
import com.dsc.livrarialmfinal.model.Livro;
import com.dsc.livrarialmfinal.model.User;
import com.dsc.livrarialmfinal.service.ItemPedidoService;
import com.dsc.livrarialmfinal.service.LivroService;
import com.dsc.livrarialmfinal.service.UserService;

@Controller
@RequestMapping("/livraria")
public class LivrariaController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@GetMapping("/")
	public ModelAndView livraria(Livro livro, User user, ItemPedido itemPedido) {
		ModelAndView mv = new ModelAndView("/livraria/index-loja");
		mv.addObject("itempedido", itemPedido);
		mv.addObject("itempedidos", itemPedidoService.listaAll());
		mv.addObject("livros", livroService.listaAll());
		mv.addObject("user", user);
		return mv;
	}

}

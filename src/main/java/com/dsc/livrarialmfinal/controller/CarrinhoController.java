package com.dsc.livrarialmfinal.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsc.livrarialmfinal.model.Carrinho;
import com.dsc.livrarialmfinal.model.ItemCarrinho;
import com.dsc.livrarialmfinal.model.Livro;
import com.dsc.livrarialmfinal.model.User;
import com.dsc.livrarialmfinal.repository.LivroRepository;
import com.dsc.livrarialmfinal.repository.UserRepository;
import com.dsc.livrarialmfinal.service.CarrinhoService;
import com.dsc.livrarialmfinal.service.ItemCarrinhoService;
import com.dsc.livrarialmfinal.service.LivroService;
import com.dsc.livrarialmfinal.service.UserService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemCarrinhoService itemCarrinhoService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@RequestMapping("/cart")
	public String carrinho(Model model, Principal principal) {
		User user = userRepository.findByUsername(principal.getName());
		Carrinho carrinho = user.getCarrinho();
		
		List<ItemCarrinho> itemCarrinhoList = itemCarrinhoService.findByCarrinho(carrinho);
		
		carrinhoService.updateCarrinho(carrinho);
		
		model.addAttribute("itemCarrinhoList", itemCarrinhoList);
		model.addAttribute("carrinho", carrinho);
		
		return "carrinho";
	}
	
	@RequestMapping("/add")
	public String addItem(@ModelAttribute("livro") Livro livro, Model model, Principal principal) {
		//User user = userRepository.findByUsername(principal.getName());
		User user = new User();
		
		livro = livroService.findOne(livro.getId());
		
		ItemCarrinho itemCarrinho = itemCarrinhoService.addLivroToItemCarrinho(livro, user);
		model.addAttribute("addBookSucess", true);
		return "redirect:/livraria/";
	}
	
	
	
	

}

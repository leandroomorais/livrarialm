package com.bookstore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.model.Livro;
import com.bookstore.model.CarroItem;
import com.bookstore.model.CarroCompra;
import com.bookstore.model.User;
import com.bookstore.service.LivroService;
import com.bookstore.service.CarroItemService;
import com.bookstore.service.CarroCompraService;
import com.bookstore.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class CarroCompraController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarroItemService carroItemService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private CarroCompraService carroCompraService;
	
	@RequestMapping("/cart")
	public String carroCompra(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		CarroCompra carroCompra = user.getCarroCompra();
		
		List<CarroItem> carroItemList = carroItemService.findByCarroCompra(carroCompra);
		
		carroCompraService.atualizaCarroCompra(carroCompra);
		
		model.addAttribute("cartItemList", carroItemList);
		model.addAttribute("shoppingCart", carroCompra);
		
		return "shoppingCart";
	}

	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("book") Livro livro,
			@ModelAttribute("qty") String qtd,
			Model model, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		livro = livroService.findOne(livro.getId());
		
		if (Integer.parseInt(qtd) > livro.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/bookDetail?id="+livro.getId();
		}
		
		CarroItem carroItem = carroItemService.addLivroParaCarroItem(livro, user, Integer.parseInt(qtd));
		model.addAttribute("addBookSuccess", true);
		
		return "forward:/bookDetail?id="+livro.getId();
	}
	
	@RequestMapping("/updateCartItem")
	public String atualizaCarroCompra(
			@ModelAttribute("id") Long carroItemId,
			@ModelAttribute("qty") int qtd
			) {
		CarroItem carroItem = carroItemService.findById(carroItemId);
		carroItem.setQtd(qtd);
		carroItemService.atualizaCarroItem(carroItem);
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		carroItemService.removeCarroItem(carroItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}
}

package com.dsc.livrarialmfinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dsc.livrarialmfinal.model.ItemPedido;
import com.dsc.livrarialmfinal.model.Livro;
import com.dsc.livrarialmfinal.repository.ItemPedidoRepository;
import com.dsc.livrarialmfinal.repository.LivroRepository;
import com.dsc.livrarialmfinal.service.ItemPedidoService;
import com.dsc.livrarialmfinal.service.LivroService;


@Controller
@RequestMapping("/item-pedido")
public class ItemPedidoController {
	
//	@Autowired
//	private LivroService livroService;
//	
//	@Autowired
//	private ItemPedidoService itemPedidoService;
//	
//	@Autowired
//	LivroRepository livroRepository;
//	
//	@Autowired
//	private ItemPedidoRepository itemPedidoRepository;
//
//	private ItemPedido itemPedido;
//	
//	
//	//Métodos carrinho
//	
//		@GetMapping("/add")
//		public ModelAndView add(ItemPedido itemPedido){
//			ModelAndView mv = new ModelAndView("/itempedido/form");
//			mv.addObject("livros", livroService.listaAll());
//			mv.addObject("itemPedido", itemPedido);
//			mv.addObject("itempedidos", itemPedidoService.listaAll());
//			return mv;
//		}
//		
//
//		@GetMapping("/delete/{id}")
//		private String delete(@PathVariable("id") Long id) {
//			itemPedidoService.delete(id);
//			return "redirect:/livraria/";
//		}
//		
//		@GetMapping("/deletecar/{id}")
//		private String deletecar(@PathVariable("id") Long id) {
//			itemPedidoService.delete(id);
//			return "redirect:/item-pedido/lista";
//		}
//		
//		@GetMapping("/save")
//		public String save(@Valid ItemPedido itemPedido, BindingResult result) {
//			
//			if(result.hasErrors()) {
//				add(itemPedido);
//			}
//			
//			itemPedidoService.cadastrar(itemPedido);
//			
//			return "redirect:/livraria/";
//			
//		}
//		
//		@GetMapping("/lista")
//		private ModelAndView findAll() {
//			ModelAndView mv = new ModelAndView("itempedido/list");
//			mv.addObject("itempedidos", itemPedidoService.listaAll());
//			return mv;
//		}
//	
	

	
	
	
}

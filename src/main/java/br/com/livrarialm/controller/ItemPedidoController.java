package br.com.livrarialm.controller;

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

import br.com.livrarialm.model.ItemPedido;
import br.com.livrarialm.model.Livro;
import br.com.livrarialm.repository.ItemPedidoRepository;
import br.com.livrarialm.repository.LivroRepository;
import br.com.livrarialm.service.ItemPedidoService;
import br.com.livrarialm.service.LivroService;

@Controller
@RequestMapping("/item-pedido")
public class ItemPedidoController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	private ItemPedido itemPedido;
	
	
	@GetMapping("/add")
	public ModelAndView add(ItemPedido itemPedido){
		ModelAndView mv = new ModelAndView("/itempedido/form");
		mv.addObject("livros", livroService.listaAll());
		mv.addObject("itemPedido", itemPedido);
		mv.addObject("itempedidos", itemPedidoService.listaAll());
		return mv;
	}
	

	@GetMapping("/delete/{id}")
	private String delete(@PathVariable("id") Long id) {
		itemPedidoService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/save")
	public String save(@Valid ItemPedido itemPedido, BindingResult result) {
		
		if(result.hasErrors()) {
			add(itemPedido);
		}

		itemPedidoService.cadastrar(itemPedido);
		ModelAndView mv = findAll();
		return "redirect:/";
		
	}
	
	@RequestMapping("/addcart/{id}")
	public ModelAndView addProduct(@PathVariable("id") Long id) {
		livroRepository.findById(id).ifPresent(itemPedidoService::addLivro);
		return findAll();
	}
	
	@GetMapping("/lista")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/itempedido/list");
		mv.addObject("itempedidos", itemPedidoService.listaAll());
		return mv;
	}
	
	@GetMapping("/comprar")
	public ModelAndView comprar(ItemPedido itemPedido) {
		ModelAndView mv = new ModelAndView("/itempedido/comprar");
		mv.addObject("itempedido", itemPedido);
		mv.addObject("itempedidos", itemPedidoService.listaAll());
		return mv;
	}
	
	

	
	
	
}

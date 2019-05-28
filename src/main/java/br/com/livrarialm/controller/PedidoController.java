package br.com.livrarialm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livrarialm.model.Pedido;
import br.com.livrarialm.service.LivroService;
import br.com.livrarialm.service.PedidoService;
import br.com.livrarialm.service.UsuarioService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private UsuarioService usuarioService;
 	
	@GetMapping("/comprar")
	public ModelAndView add(Pedido pedido) {
		ModelAndView mv = new ModelAndView("/pedido/comprar");
		mv.addObject("pedido", pedido);
		mv.addObject("livros", livroService.listaAll());
		mv.addObject("usuarios", usuarioService.listaAll());
		return mv;
	}
	
	@GetMapping("/edit/{}")
	private ModelAndView edit(@PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findOne(id);
		return add(pedido);
	}
	
	@GetMapping("/save")
	public String save(Pedido pedido) {
		
		
		pedidoService.cadastrar(pedido);
		ModelAndView mv = findAll();
		return "redirect:/";
	}
	
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("pedido/list");
		mv.addObject("pedidos", pedidoService.listaAll());
		return mv;
	}

}

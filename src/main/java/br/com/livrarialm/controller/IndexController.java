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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.livrarialm.model.Autor;
import br.com.livrarialm.model.Categoria;
import br.com.livrarialm.model.ItemPedido;
import br.com.livrarialm.model.Livro;
import br.com.livrarialm.model.Pedido;
import br.com.livrarialm.model.Usuario;
import br.com.livrarialm.repository.LivroRepository;
import br.com.livrarialm.service.AutorService;
import br.com.livrarialm.service.CategoriaService;
import br.com.livrarialm.service.ItemPedidoService;
import br.com.livrarialm.service.LivroService;
import br.com.livrarialm.service.PedidoService;
import br.com.livrarialm.service.UsuarioService;

@Controller
public class IndexController {
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private UsuarioService usuarioService; 
	

	@RequestMapping("/livraria")
	public ModelAndView home(Livro livro, ItemPedido itemPedido, Pedido pedido, Usuario usuario) {
		ModelAndView mv = new ModelAndView("index-loja");
		mv.addObject("livro", livro);
		mv.addObject("livros", livroService.listaAll());
		mv.addObject("itempedido", itemPedido);
		mv.addObject("itempedidos", itemPedidoService.listaAll());
		mv.addObject("pedido", pedido);
		mv.addObject("pedidos", pedidoService.listaAll());
		mv.addObject("usuario", usuario);
		
		return mv;
		
	}
	
	@RequestMapping("/entrar")
	public ModelAndView login(Usuario usuario) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("usuario", usuario);
		return mv;
	}
	

	


}

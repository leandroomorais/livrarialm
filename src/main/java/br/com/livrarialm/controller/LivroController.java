package br.com.livrarialm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livrarialm.model.Livro;
import br.com.livrarialm.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@GetMapping("/add")
	public ModelAndView add(Livro livro) {
		ModelAndView mv = new ModelAndView("livro/formulario");
		mv.addObject("livro", livro);
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	private ModelAndView edit(@PathVariable("id") Long id) {
		Livro livro = service.findOne(id);
		return add(livro);
	}
	
	@GetMapping("/delete/{id}")
	private ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Livro livro, BindingResult result) {
		if(result.hasErrors()) {
			return add(livro);
		}
		
		service.cadastrar(livro);
		ModelAndView mv = findAll();
		return mv;
	}
	
	@GetMapping("/lista")
	private ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("livro/list");
		mv.addObject("livros", service.listaAll());
		return mv;
	}
	
	
	
	

}

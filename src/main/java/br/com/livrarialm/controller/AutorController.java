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

import br.com.livrarialm.model.Autor;
import br.com.livrarialm.service.AutorService;

@Controller
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping("/add")
	public ModelAndView add(Autor autor) {
		ModelAndView mv = new ModelAndView("/autor/form");
		mv.addObject("autor", autor);
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	private ModelAndView edit(@PathVariable("id") Long id) {
		Autor autor = autorService.findOne(id);
		return add(autor);
	}
	
	@GetMapping("/delete/{id}")
	private ModelAndView delete(@PathVariable("id") Long id) {
		autorService.delete(id);
		return findAll();
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Autor autor, BindingResult result) {
		if(result.hasErrors()) {
			return add(autor);
		}
		
		autorService.cadastrar(autor);
		ModelAndView mv = findAll();
		return mv;
	}
	
	
	private ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("autor/list");
		mv.addObject("autores", autorService.listaAll());
		return mv;
	}
	

}

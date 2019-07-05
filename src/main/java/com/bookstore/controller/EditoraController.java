package com.bookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bookstore.model.Editora;
import com.bookstore.service.EditoraService;

@Controller
@RequestMapping("/editora")
public class EditoraController {
	
	@Autowired
	private EditoraService editoraService;
			
	@GetMapping("/add")
	public ModelAndView add(Editora editora) {
		ModelAndView mv = new ModelAndView("/editora/form");
		mv.addObject("editora", editora);
		return mv;
	}
		
	@GetMapping("/edit/{id}")
	private ModelAndView edit( @PathVariable("id") Long id) {
		Editora editora = editoraService.findOne(id);
		return add(editora);
	}
	

	@GetMapping("/delete/{id}")
	private ModelAndView delete( @PathVariable("id") Long id) {
		editoraService.delete(id);
		return findAll();
	}


	
	@PostMapping("/save")
    public ModelAndView save(@Valid Editora editora, BindingResult result) {
		 
		if(result.hasErrors()) {
			return add(editora);
	    }
		editoraService.cadastrar(editora);
		ModelAndView mv = findAll().addObject("success","A Editora foi cadastrada!"); 
		return mv;
    }

	@GetMapping("/lista")
	private ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("editora/list");
        mv.addObject("editoras", editoraService.listaAll());
        return mv;
	}

}

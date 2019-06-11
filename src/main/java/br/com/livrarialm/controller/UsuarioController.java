package br.com.livrarialm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.livrarialm.model.Usuario;
import br.com.livrarialm.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/add")
	public ModelAndView add(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/usuario/formuser");
		mv.addObject("usuario", usuario);
		return mv;
	}

	



	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {
			return add(usuario).addObject("msg", "Erro ao cadastrar");
		}
		
		usuarioService.save(usuario);
		ModelAndView mv = add(usuario);
		mv.addObject("msg", "Cadastro realizado com sucesso!");
		return mv;
	}

	@GetMapping("/lista")
	private ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("usuario/list");
		mv.addObject("usuarios", usuarioService.listaAll());
		return mv;
	}

}

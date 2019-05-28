package br.com.livrarialm.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.livrarialm.model.Imagem;
import br.com.livrarialm.service.ImagemService;

@Controller
@RequestMapping("/imagem")
public class ImagemController {
	
	private static final String BASE_PATH = "/images";
	private static final String FILENAME = "{filename:.+}";

	@Autowired
	private ImagemService imagemService;


	@GetMapping("/add")
	public ModelAndView add(Imagem imagem) {
		ModelAndView mv = new ModelAndView("imagem/form");
		return mv;
	}

//	@RequestMapping(method = RequestMethod.POST, value = BASE_PATH)
//	public String createFile(@RequestParam("file") MultipartFile file,
//							 RedirectAttributes redirectAttributes) {
//		try {
//			imageService.createImagem(file);
//			redirectAttributes.addFlashAttribute("flash.message", "Successfully uploaded " + file.getName());
//		} catch (IOException e) {
//			redirectAttributes.addFlashAttribute("flash.message", "Failed to upload " + file.getName() + " => " + e.getMessage());
//		}
//		return "redirect:/imagem/add";
//	}
	
	@PostMapping("/save")
	public ModelAndView save(Imagem imagem, @RequestParam("file") MultipartFile file, BindingResult result) throws IOException {
		if(result.hasErrors()) {
			return add(imagem);
		}
		try {
			imagemService.createImagem(file);
		}catch(IOException e) {
			
		}
		
		ModelAndView mv = findAll();
		return mv;
	}
	
	@GetMapping("/lista")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("imagem/list");
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = BASE_PATH + "/" + FILENAME + "/raw")
	@ResponseBody
	public ResponseEntity<?> oneRawImage(@PathVariable String filename) {

		try {
			Resource file = imagemService.findOneImage(filename);
			return ResponseEntity.ok()
					.contentLength(file.contentLength())
					.contentType(MediaType.IMAGE_JPEG)
					.body(new InputStreamResource(file.getInputStream()));
		} catch (IOException e) {
			return ResponseEntity.badRequest()
					.body("Couldn't find " + filename + " => " + e.getMessage());
		}

	}

}

package br.com.livrarialm.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.livrarialm.model.Imagem;
import br.com.livrarialm.repository.ImagemRepository;

@Service
public class ImagemService {

	private String UPLLOAD_ROOT = System.getProperty("user.dir");

	@Autowired
	private ImagemRepository repository;
	@Autowired
	private ResourceLoader resourceLoader;


	public Resource findOneImage(String filename) {
		return resourceLoader.getResource("file:" + UPLLOAD_ROOT + "/" + filename);
	}
	
	public List<Imagem>listaAll() {
		return (List<Imagem>) repository.findAll();
	}

	public void createImagem(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			Files.copy(file.getInputStream(), Paths.get(UPLLOAD_ROOT, file.getOriginalFilename()));
			repository.save(new Imagem(file.getOriginalFilename()));
		}

	}
	

}

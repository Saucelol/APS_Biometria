package aps.biometria.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArquivoController {

	// Pasta onde vai salvar a imagem
	private static String UPLOAD_DIR = "biometria/img/in/";

	@PostMapping("/upload")
	public ModelAndView handleFileUpload(MultipartFile file) {
		ModelAndView mv = new ModelAndView();

		try {
			// Deleta todos os arquivos antes de salvar
			deleteAllFilesInFolder(UPLOAD_DIR);

			// Salva o arquivo na pasta
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
			Files.write(path, bytes);
			// Salvo com sucesso
			mv.addObject("message", "Arquivo salvo com suscesso: " + file.getOriginalFilename());
			mv.setViewName("/home/index");

			// Tratamento de erro(NÃO SEI PORQUE AS VEZES NÃO CONSEGUE DELETAR)
			// PIOR DOS CASOS APAGUE A PASTA "biometria/img/in/" MANUALMENTE
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			mv.addObject("message", "Falha ao salvar o arquivo: " + e.getMessage());
			mv.setViewName("/login/LoginPage");
		}

		return mv;
	}

	// Metodo de deletar
	private void deleteAllFilesInFolder(String folderPath) throws IOException {
		// Pega a pasta
		Path folder = Paths.get(folderPath);
		// Se tiver arquivos na pasta tenta colocar num vetor
		if (Files.exists(folder)) {
			try (Stream<Path> files = Files.list(folder)) {
				files.forEach(file -> {
					// Tenta deletar os arquivos do vetor
					try {
						Files.delete(file);
					} catch (IOException e) {
						System.err.println("Não foi possivel deletar: " + file.getFileName());
					}
				});
			}
		} else {
			// Cria a pasta caso não exista
			Files.createDirectories(folder);
		}
	}
}

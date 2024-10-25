package aps.biometria.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.Celebrity;
import software.amazon.awssdk.services.rekognition.model.Image;
import software.amazon.awssdk.services.rekognition.model.RecognizeCelebritiesRequest;
import software.amazon.awssdk.services.rekognition.model.RecognizeCelebritiesResponse;

@Controller
public class BiometriaController {

	// Onde fica as imagens a serem processadas
	private static final String SOURCE_IMAGE_PATH_IN = "biometria/img/in/";

	@GetMapping("/CelebrityRequest")
	// Metodo para reconhecer qualquer celebridade
	public ModelAndView CelebrityRecognition() {

		String nome = null;

		// Cria o cliente para o Rekognition
		RekognitionClient rekognitionClient = RekognitionClient.builder().region(Region.US_WEST_1)
				.credentialsProvider(ProfileCredentialsProvider.create()).build();

		// Pasta onde a imagem fica guardada
		String folderPath = SOURCE_IMAGE_PATH_IN;
		File folder = new File(folderPath);

		// Cria uma lista com todas as imagens na pasta (SE TUDO TIVER FUNCIONANDO SO
		// DEVE TER UMA)
		File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg")
				|| name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpeg"));
		if (listOfFiles == null || listOfFiles.length == 0) {
			System.out.println("Não foi possivel encontrar nenhuma imagem na pasta.");
		} else {
			for (File file : listOfFiles) {
				if (file.isFile()) {
					try {
						// Carrega a imagem da pasta
						SdkBytes imageBytes = SdkBytes.fromInputStream(new FileInputStream(file));

						// Builda o objeto da imagem
						Image image = Image.builder().bytes(imageBytes).build();

						// Cria a requisição de reconhecimento
						RecognizeCelebritiesRequest request = RecognizeCelebritiesRequest.builder().image(image)
								.build();

						// Chama a API AWS Rekognition
						RecognizeCelebritiesResponse result = rekognitionClient.recognizeCelebrities(request);

						// Processa o resultado e imprime no console
						List<Celebrity> celebrityList = result.celebrityFaces();
						if (!celebrityList.isEmpty()) {
							System.out.println("Image: " + file.getName());
							for (Celebrity celebrity : celebrityList) {
								// Salva uma variavel com o nome
								nome = celebrity.name();
								System.out.println("Celebrity: " + celebrity.name());
								System.out.println("Confidence: " + celebrity.matchConfidence());
								System.out.println("More Info: " + celebrity.urls());
								System.out.println("---------------------------");

							}
						} else {
							System.out.println("No celebrities detected in " + file.getName());
						}

					} catch (FileNotFoundException e) {
						System.err.println("File not found: " + e.getMessage());
					} catch (@SuppressWarnings("hiding") IOException e) {
						System.err.println("IO exception: " + e.getMessage());
					}
				}
			}
		}

		// Fecha o cliente
		rekognitionClient.close();
		// Retorna a View se reconhecer alguem
		ModelAndView mv = new ModelAndView();
		if (nome != null) {
			nome = ("Bem vindo ao banco de dados: " + nome);
			mv.addObject("msg_nome", nome);
			mv.setViewName("/home/welcome");
			System.out.print(nome);
		} else {
			// Tem jeito melhor de fazer isso
			mv.addObject("msg_erro", nome);
			mv.setViewName("/home/index2");
			System.out.print("Pessoa não identificada");
		}
		return mv;
	}

	@GetMapping("/CelebrityRequest2")
	// Metodo para reconhecer o Terry Crews
	public ModelAndView CelebrityRecognition2() {

		String nome = null;

		// Cria o cliente para o Rekognition
		RekognitionClient rekognitionClient = RekognitionClient.builder().region(Region.US_WEST_1)
				.credentialsProvider(ProfileCredentialsProvider.create()).build();

		// Pasta onde a imagem fica guardada
		String folderPath = SOURCE_IMAGE_PATH_IN;
		File folder = new File(folderPath);

		// Cria uma lista com todas as imagens na pasta (SE TUDO TIVER FUNCIONANDO SO
		// DEVE TER UMA)
		File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg")
				|| name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpeg"));
		if (listOfFiles == null || listOfFiles.length == 0) {
			System.out.println("Não foi possivel encontrar nenhuma imagem na pasta.");
		} else {
			for (File file : listOfFiles) {
				if (file.isFile()) {
					try {
						// Carrega a imagem da pasta
						SdkBytes imageBytes = SdkBytes.fromInputStream(new FileInputStream(file));

						// Builda o objeto da imagem
						Image image = Image.builder().bytes(imageBytes).build();

						// Cria a requisição de reconhecimento
						RecognizeCelebritiesRequest request = RecognizeCelebritiesRequest.builder().image(image)
								.build();

						// Chama a API AWS Rekognition
						RecognizeCelebritiesResponse result = rekognitionClient.recognizeCelebrities(request);

						// Processa o resultado e imprime no console
						List<Celebrity> celebrityList = result.celebrityFaces();
						if (!celebrityList.isEmpty()) {
							System.out.println("Image: " + file.getName());
							for (Celebrity celebrity : celebrityList) {
								// salva uma variavel com o nome
								nome = celebrity.name();
								System.out.println("Celebrity: " + celebrity.name());
								System.out.println("Confidence: " + celebrity.matchConfidence());
								System.out.println("More Info: " + celebrity.urls());
								System.out.println("---------------------------");

							}
						} else {
							System.out.println("No celebrities detected in " + file.getName());
						}

					} catch (FileNotFoundException e) {
						System.err.println("File not found: " + e.getMessage());
					} catch (@SuppressWarnings("hiding") IOException e) {
						System.err.println("IO exception: " + e.getMessage());
					}
				}
			}
		}

		// Fecha o cliente
		rekognitionClient.close();
		// Retorna a View se reconhecer o Terry Crews
		ModelAndView mv = new ModelAndView();
		System.out.print(nome);
		switch (nome) {
		case "Terry Crews":
			nome = ("Bem vindo ao banco de dados: " + nome);
			mv.addObject("msg_nome", nome);
			mv.setViewName("/home/welcome2");
			System.out.print(nome);
			break;

		default:
			// Tem jeito melhor de fazer isso
			mv.addObject("msg_erro", nome);
			mv.setViewName("/home/index2");
			System.out.print(" Não é o Terry Crews");
		}
		return mv;
	}
}

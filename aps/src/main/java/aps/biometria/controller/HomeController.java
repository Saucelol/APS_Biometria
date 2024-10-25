package aps.biometria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import aps.biometria.dao.Nivel1Dao;
import aps.biometria.dao.Nivel2Dao;
import aps.biometria.dao.Nivel3Dao;
import aps.biometria.entities.Nivel1;
import aps.biometria.entities.Nivel2;
import aps.biometria.entities.Nivel3;

@Controller
//Controllers relacionados as paginas
public class HomeController {

	@Autowired()
	private Nivel1Dao nivel1repositorio;
	@Autowired()
	private Nivel2Dao nivel2repositorio;
	@Autowired()
	private Nivel3Dao nivel3repositorio;

	@GetMapping("/")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login/LoginPage");
		return mv;
	}

	@GetMapping("/home")
	public ModelAndView Home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home/index");
		return mv;
	}

	@GetMapping("/ListarNivel1")
	public ModelAndView ListNivel1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/exibir/Nivel1");
		mv.addObject("Nivel1List", nivel1repositorio.findAll());
		mv.addObject("nivel1", new Nivel1());
		return mv;
	}

	@GetMapping("/deleteNivel1/{id}")
	public ModelAndView deleteNivel1(@PathVariable int id) {
		nivel1repositorio.deleteById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarNivel1");
		return mv;
	}

	@PostMapping("InsertNivel1")
	public ModelAndView inserirNivel1(@Valid Nivel1 IdNivel1, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarNivel1");
		nivel1repositorio.save(IdNivel1);
		return mv;
	}

	@GetMapping("/ListarNivel2")
	public ModelAndView ListNivel2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/exibir/Nivel2");
		mv.addObject("Nivel2List", nivel2repositorio.findAll());
		mv.addObject("nivel2", new Nivel2());
		return mv;
	}

	@GetMapping("/deleteNivel2/{id}")
	public ModelAndView deleteNivel2(@PathVariable int id) {
		nivel2repositorio.deleteById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarNivel2");
		return mv;
	}

	@PostMapping("InsertNivel2")
	public ModelAndView inserirNivel2(@Valid Nivel2 IdNivel2, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarNivel2");
		nivel2repositorio.save(IdNivel2);
		return mv;
	}

	@GetMapping("/ListarNivel3")
	public ModelAndView ListNivel3() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/exibir/Nivel3");
		mv.addObject("Nivel3List", nivel3repositorio.findAll());
		mv.addObject("nivel3", new Nivel3());
		return mv;
	}

	@GetMapping("/deleteNivel3/{id}")
	public ModelAndView deleteNivel3(@PathVariable int id) {
		nivel3repositorio.deleteById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarNivel3");
		return mv;
	}

	@PostMapping("InsertNivel3")
	public ModelAndView inserirNivel3(@Valid Nivel3 IdNivel3, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListarNivel3");
		nivel3repositorio.save(IdNivel3);
		return mv;
	}

}

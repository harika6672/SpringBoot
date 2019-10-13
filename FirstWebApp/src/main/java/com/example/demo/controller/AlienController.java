package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alien;

@RestController

public class AlienController {
	@Autowired
	 AlienRepo repo;
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	/*@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}*/
/*	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(null);
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(103));
		System.out.println(repo.findByTechSorted("Java"));

		mv.setViewName("showalien.jsp");
		mv.addObject(alien);
	   return mv;
	}*/
	@GetMapping(path="/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable int aid) {
		return repo.findById(aid);
	}
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	@PutMapping("/alien")
	public Alien saveOrupdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
}

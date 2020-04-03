package org.sid.controllers;

import java.util.List;

import org.sid.models.Film;
import org.sid.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author vince
 *Rassemble les Controllers de Film
 */
@RestController
@CrossOrigin
@RequestMapping("films")
public class FilmController {
	@Autowired
	private FilmService service;
	@GetMapping("")
	private List<Film> findAll(){
		return this.service.findAll();
	}

	@GetMapping("{id}")
	private Film findById(@PathVariable String id){
		return this.service.findById(id);
	}

	@GetMapping("film/{titre}")
	private Film findByTitre(@PathVariable String titre){
		return this.service.findByTitre(titre);
	}

	@GetMapping("{id}/recette")
	private int findSeanceByRecette(@PathVariable String id) {
		return this.service.recetteFilm(id);
	}

	@PostMapping("")
	public Film save(@RequestBody Film entity) {
		return this.service.save(entity);
	}

	@PutMapping("")
	public Film update(@RequestBody Film entity) {
		return this.service.save(entity);
	}	

	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}

	@DeleteMapping("")
	public void delete(@RequestBody Film s) {
		this.service.delete(s.getId());
	}
}

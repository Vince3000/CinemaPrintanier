package org.sid.controllers;

import java.util.List;

import org.sid.models.Seance;
import org.sid.services.SeancesService;
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
 *Rassemble les Controllers de Seances
 */
@RestController
@CrossOrigin
@RequestMapping("seances")
public class SeancesController {
	@Autowired
	private SeancesService service;

	@GetMapping("")
	private List<Seance> findAll(){
		return this.service.findAll();
	}

	@GetMapping("{id}")
	private Seance findById(@PathVariable String id){
		return this.service.findById(id);
	}

	@GetMapping("type/{type}")//OK
	private List<Seance> findByType(@PathVariable String type){
		return this.service.findByType(type);
	}

	@GetMapping("{id}/places")//OK
	private String findPlaceSeance(@PathVariable String id) {
		int p = this.service.findPlaceSeance(id);
		String s=null;
		if (p>1) s= "s";
		return "Pour cette séance, il reste " + this.service.findPlaceSeance(id) + " place" + s;
	}

	@GetMapping("{id}/recette")//OK
	private String findSeanceByRecette(@PathVariable String id) {
		return "Cette séance à rapporté " + this.service.recetteSeance (id) + "€";
	}

	@GetMapping("horaire/{min}/{max}")//OK
	private List<Seance> findByHoraire(@PathVariable String min, @PathVariable String max){
		return this.service.findByHoraire(min, max);
	}

	@GetMapping("genre/{genre}")//OK
	private List<Seance> findByGenre(@PathVariable String genre){
		return this.service.seanceByGenre(genre);
	}

	@GetMapping("film/{nom}")//OK
	private Seance seanceByFilm(@PathVariable String nom) {
		return this.service.seanceByFilm(nom);
	}
	@GetMapping("age/{age}")//OK
	private List<Seance> seanceByAge(@PathVariable String age){
		return this.service.seanceByAge(age);
	}

	@PostMapping("")
	public Seance save(@RequestBody Seance entity) {
		return this.service.save(entity);
	}

	@PostMapping("{idSeance}/assister/{idClient}")
	public List<String>  addClient(@PathVariable String idSeance,@PathVariable String idClient) {
		return this.service.addClient(idSeance, idClient);
		
	}

@PutMapping("")
public Seance update(@RequestBody Seance entity) {
	return this.service.save(entity);
}

@DeleteMapping("{id}")
public void delete(@PathVariable String id) {
	this.service.delete(id);
}

@DeleteMapping("")
public void delete(@RequestBody Seance s) {
	this.service.delete(s.getId());
}
}

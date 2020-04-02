package org.sid.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
	@GetMapping("recherche/{id}")
	private Optional<Seance> findById(@PathVariable String id){
		return this.service.findById(id);
	}
	@GetMapping("types/{type}")
	private List<Seance> findByType(@PathVariable String type){
		return this.service.findByType(type);
	}
	@GetMapping("recherche/seance/{film}")
	private List<Seance> findByFilm(@PathVariable String film){
		return this.service.findByFilm(film);
	}
	@GetMapping("debut/{debut}/fin/{fin}")
	private List<Seance> findByHoraire(LocalDateTime debut, LocalDateTime fin){
		return this.service.findByHoraire(debut, fin);
	}
//	@GetMapping("genre/{genre}")
//	private List<Seance> findByGenre(@PathVariable String genre){
//		return this.service.findByGenre(genre);
//	}
	@PostMapping("")
	public Seance save(@RequestBody Seance entity) {
		return this.service.save(entity);
	}
	@PostMapping("ajoutclient")
	public Seance addClient(String idseance,String idAssister) {
		return this.service.addClient(idseance, idAssister);
	}
	@PutMapping("")
	public Seance update(@RequestBody Seance entity) {
		return this.service.save(entity);
	}
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	@DeleteMapping("")
	public void delete(@RequestBody Seance s) {
		this.service.delete(s.getId());
	}
}

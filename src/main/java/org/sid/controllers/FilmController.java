package org.sid.controllers;

import java.util.List;
import java.util.Optional;

import org.sid.models.FilmModel;
import org.sid.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class FilmController {
	@Autowired
	private FilmService service;
	@GetMapping("")
	private List<FilmModel> findAll(){
		return this.service.findAll();
	}
	@GetMapping("{id}")
	private Optional<FilmModel> findById(@PathVariable String id){
		return this.service.findById(id);
	}
	@PostMapping("")
	public FilmModel save(@RequestBody FilmModel entity) {
		return this.service.save(entity);
	}
	@PutMapping("")
	public FilmModel update(@RequestBody FilmModel entity) {
		return this.service.save(entity);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	@DeleteMapping("")
	public void delete(@RequestBody FilmModel s) {
		this.service.delete(s.getId());
	}
}

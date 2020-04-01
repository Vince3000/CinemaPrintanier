package org.sid.controllers;

import java.util.List;
import java.util.Optional;

import org.sid.models.SeanceModel;
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

@RestController
@CrossOrigin
@RequestMapping("seances")
public class SeancesController {
	@Autowired
	private SeancesService service;
	@GetMapping("")
	private List<SeanceModel> findAll(){
		return this.service.findAll();
	}
	@GetMapping("{id}")
	private Optional<SeanceModel> findById(@PathVariable String id){
		return this.service.findById(id);
	}
	@PostMapping("")
	public SeanceModel save(@RequestBody SeanceModel entity) {
		return this.service.save(entity);
	}
	@PutMapping("")
	public SeanceModel update(@RequestBody SeanceModel entity) {
		return this.service.save(entity);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	@DeleteMapping("")
	public void delete(@RequestBody SeanceModel s) {
		this.service.delete(s.getId());
	}
}

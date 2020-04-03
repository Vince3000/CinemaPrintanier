package org.sid.controllers;

import java.util.List;
import org.sid.models.Salle;
import org.sid.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
@RequestMapping("salles")
public class SalleController {
	@Autowired
	private SalleService service;

	@PostMapping("")
	public Salle save(@RequestBody Salle entity) {
		return this.service.save(entity);
	}

	@GetMapping("")
	public List<Salle> findall(){
		return this.service.findAll();
	}
}

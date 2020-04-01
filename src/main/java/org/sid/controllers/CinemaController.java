package org.sid.controllers;

import java.util.List;
import java.util.Optional;

//import org.sid.dto.CinemaDto;
import org.sid.models.CinemaModel;
import org.sid.services.CinemaService;
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
 *Controller de cinéma
 */

@RestController
@CrossOrigin
@RequestMapping("cinemas")
public class CinemaController {

	@Autowired
	private CinemaService service;

	@GetMapping("")
	private List<CinemaModel> findAll() {
		return this.service.findAll();
	}

	@GetMapping("{id}")
	private Optional<CinemaModel> findById(@PathVariable String id){
		return this.service.findById(id);
	}

	@PostMapping("")
	public CinemaModel save(@RequestBody CinemaModel entity) {
		return this.service.save(entity);
	}
	@PutMapping("")
	public CinemaModel update(@RequestBody CinemaModel entity) {
		return this.service.save(entity);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
}

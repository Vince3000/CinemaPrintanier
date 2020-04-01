package org.sid.controllers;

import java.util.List;
import java.util.Optional;

import org.sid.models.ClientModel;
import org.sid.services.ClientService;
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
@RequestMapping("clients")
public class ClientController {
	@Autowired
	private ClientService service;

	@GetMapping("")
	private List<ClientModel> findAll() {
		return this.service.findAll();
	}

	@GetMapping("{id}")
	private Optional<ClientModel> findById(@PathVariable String id){
		return this.service.findById(id);
	}
	@PostMapping("")
	public ClientModel save(@RequestBody ClientModel entity) {
		return this.service.save(entity);
	}
	@PutMapping("")
	public ClientModel update(@RequestBody ClientModel entity) {
		return this.service.save(entity);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	@DeleteMapping("")
	public void delete(@RequestBody ClientModel c) {
		this.service.delete(c.getId());
	}
}

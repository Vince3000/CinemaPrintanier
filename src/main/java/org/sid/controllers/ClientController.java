package org.sid.controllers;

import java.util.List;
import java.util.Optional;

import org.sid.models.Client;
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
/**
 * @author vince
 *Rassemble les Controllers de client
 */
@RestController
@CrossOrigin
@RequestMapping("clients")
public class ClientController {
	@Autowired
	private ClientService service;

	@GetMapping("")
	private List<Client> findAll() {
		return this.service.findAll();
	}
	@GetMapping("recherche/{id}")
	private Optional<Client> findById(@PathVariable String id){
		return this.service.findById(id);
	}
	@PostMapping("")
	public Client save(@RequestBody Client entity) {
		return this.service.save(entity);
	}
	@PutMapping("")
	public Client update(@RequestBody Client entity) {
		return this.service.save(entity);
	}
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	@DeleteMapping("")
	public void delete(@RequestBody Client c) {
		this.service.delete(c.getId());
	}
}

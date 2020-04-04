package org.sid.controllers;

import org.sid.models.Cinema;
import org.sid.models.Client;
import org.sid.services.CinemaService;
import org.sid.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vince
 *Rassemble les Controllers de cinéma
 */

@RestController
@CrossOrigin
@RequestMapping("cinemas")
public class CinemaController {
	@Autowired
	private ClientService client;
	@Autowired
	private CinemaService cinema;

	@PostMapping("")
	public Client save(@RequestBody Client s) {
		return this.client.save(s);
	}

	@PostMapping("cinema")
	public Cinema saveCinema(@RequestBody Cinema s) {
		return this.cinema.saveCinema(s);
	}

}

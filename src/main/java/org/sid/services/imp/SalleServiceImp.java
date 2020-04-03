package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Salle;
import org.sid.repositories.SalleRepository;
import org.sid.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SalleServiceImp implements SalleService {
	@Autowired
	private SalleRepository salle;
	@Override
	public Salle save(Salle s) {
		return this.salle.save(s);
	}
	public List<Salle> findAll() {
		return this.salle.findAll();
	}
	@Override
	public Salle findById(String id) {
		Optional<Salle> optional =  this.salle.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id "+id+" n'est pas valide pour cette salle");
	}
}

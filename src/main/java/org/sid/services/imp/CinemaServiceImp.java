package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Cinema;
import org.sid.repositories.CinemaRepository;
import org.sid.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CinemaServiceImp implements CinemaService{
	@Autowired
	private CinemaRepository cine;
	//@Autowired
	//private SalleService salleservice;

	@Override
	public List<Cinema> findAll(){
		return this.cine.findAll();
	}

	@Override
	public Cinema findById(String id) {
		Optional<Cinema> optional =  this.cine.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id "+id+" n'est pas valide ce cinema");
	}

	@Override
	public Cinema save(Cinema s) {
		return this.cine.save(s);
	}

	@Override
	public void delete(String id) {
		this.cine.deleteById(id);
	}

	@Override
	public Cinema addSalle(String idcinema, String idsalle) {
		// TODO Auto-generated method stub
		return null;
	}

	//	@Override //A tester
	//	public Cinema addSalle(String idcinema, String idsalle) {
	//		Cinema c = this.findById(idcinema).get();
	//		Optional<Salle> s = salleservice.findById(idsalle);
	//		Salle salle = s.get();
	//		c.setSalles(salle);
	//		return c;
	//	}
}

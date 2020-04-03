package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Salle;
import org.sid.repositories.SalleRepository;
import org.sid.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Optional<Salle> findById(String id) {
		// TODO Auto-generated method stub
		return this.salle.findById(id);
	}
}

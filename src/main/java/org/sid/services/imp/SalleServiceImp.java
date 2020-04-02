package org.sid.services.imp;

import org.sid.models.Salle;
import org.sid.repositories.CinemaRepository;
import org.sid.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalleServiceImp implements SalleService {
	@Autowired
	private CinemaRepository cine;
	@Override
	public Salle save(Salle s) {
		return this.cine.save(s);
	}
}

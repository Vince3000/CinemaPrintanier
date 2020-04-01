package org.sid.services.imp;

import org.sid.models.SalleModel;
import org.sid.repositories.CinemaRepository;
import org.sid.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalleServiceImp implements SalleService {
	@Autowired
	private CinemaRepository cine;
	@Override
	public SalleModel save(SalleModel s) {
		return this.cine.save(s);
	}
}

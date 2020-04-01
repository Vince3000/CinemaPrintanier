package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.dto.CinemaDto;
import org.sid.models.CinemaModel;
//import org.sid.models.SalleModel;
import org.sid.repositories.CinemaRepository;
import org.sid.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImp implements CinemaService{
	@Autowired
	private CinemaRepository cine;
	@Override
	public List<CinemaModel> findAll(){
		return this.cine.findAll();
	}

	@Override
	public Optional<CinemaModel> findById(String id) {
		// TODO Auto-generated method stub
		return this.cine.findById(id);
	}
	/*@Override
	public CinemaDto save(CinemaDto dto) {
		dto.setCinema(this.save(dto.getCinema()));
		for (Salle salle: dto.getSalles()) {
			salle.setCinema(dto.getCinema());
			salle.setId(this.SalleService.save(salle).getId());
		}
		return d;
	}*/
	@Override
	public void delete(String id) {
		this.cine.deleteById(id);
	}

	@Override
	public CinemaModel save(CinemaModel c) {
		// TODO Auto-generated method stub
		return this.cine.save(c);
	}

	@Override
	public CinemaDto save(CinemaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
}

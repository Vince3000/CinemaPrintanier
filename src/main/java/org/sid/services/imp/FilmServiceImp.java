package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.FilmModel;
import org.sid.repositories.FilmRepository;
import org.sid.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImp implements FilmService {
	@Autowired
	private FilmRepository seance;
	@Override
	public List<FilmModel> findAll(){
		return this.seance.findAll();
	}
	@Override
	public Optional<FilmModel> findById(String id){
		return this.seance.findById(id);
	}	
	@Override
	public FilmModel save(FilmModel s) {
		return this.seance.save(s);
	}
	@Override
	public void delete(String id) {
		this.seance.deleteById(id);
	}
	@Override
	public List<FilmModel> getByRecette(int recette) {
		return null;
	}
}

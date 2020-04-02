package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Film;
import org.sid.repositories.FilmRepository;
import org.sid.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImp implements FilmService {
	@Autowired
	private FilmRepository film;
	@Override
	public List<Film> findAll(){
		return this.film.findAll();
	}
	@Override
	public Optional<Film> findById(String id){
		return this.film.findById(id);
	}
	@Override
	public Film findByTitre(String titre) {
		// TODO Auto-generated method stub
		return this.film.findByTitre(titre);
	}
	@Override
	public List<Film> findFilmByGenre(String genre){
		return this.film.findAllByGenre(genre);
	}
	@Override
	public Film save(Film s) {
		return this.film.save(s);
	}
	@Override
	public void delete(String id) {
		this.film.deleteById(id);
	}
	@Override
	public List<Film> getByRecette(int recette) {
		return null;
	}
}

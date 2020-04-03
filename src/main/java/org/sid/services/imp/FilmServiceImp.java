package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Assister;
import org.sid.models.Film;
import org.sid.models.Seance;
import org.sid.repositories.FilmRepository;
import org.sid.services.FilmService;
import org.sid.services.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FilmServiceImp implements FilmService {
	@Autowired
	private FilmRepository film;
	@Autowired
	private SeancesService seance;

	@Override
	public List<Film> findAll(){
		return this.film.findAll();
	}

	@Override
	public Film findById(String id){
		Optional<Film> optional =  this.film.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id "+id+" n'est pas valide pour ce film");
	}

	@Override
	public Film findByTitre(String titre) {
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

	//@Override
	public List<Seance> findSeanceByGenreFilm(String genre) {
		// TODO Auto-generated method stub
		List<Film> film = this.findFilmByGenre(genre);
		if (!film.isEmpty()) return null;
		return null;
	}
	
	@Override
	public int recetteFilm (String idFilm) {
		Film film = this.findById(idFilm);
		Seance seance = this.seance.findById(film.getTitre());
		int cumul = 0;
		for (Assister s : seance.getClient()) {
			cumul+= s.getPrix();
		}
		return cumul;
	}

	@Override
	public List<Film> getByRecette(String id) {
		//		Seance seance = this.findById(idSeance);
		//		int cumul = 0;
		//		for (Assister s : seance.getClient()) {
		//			cumul+= s.getPrix();
		//		}
		return null;
	}
}

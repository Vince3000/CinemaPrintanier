package org.sid.services;

import java.util.List;

import org.sid.models.Film;

public interface FilmService {
	public List<Film> findAll();
	public Film findById(String id);
	public Film findByTitre(String titre);
	public Film save(Film s);
	public void delete(String id);
	public List<Film> getByRecette(String id);
	public List<Film> findFilmByGenre(String genre);
	public int recetteFilm(String idFilm);
}

package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.Film;

public interface FilmService {
	public List<Film> findAll();
	public Optional<Film> findById(String id);
	public Film findByTitre(String titre);
	public Film save(Film s);
	public void delete(String id);
	public List<Film> getByRecette(int recette);
}

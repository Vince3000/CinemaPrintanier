package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.FilmModel;

public interface FilmService {
	public List<FilmModel> findAll();
	public Optional<FilmModel> findById(String id);
	public Optional<FilmModel> findByGenre(String genre);
	public FilmModel findByTitre(String titre);
	public FilmModel save(FilmModel s);
	public void delete(String id);
	public List<FilmModel> getByRecette(int recette);
}

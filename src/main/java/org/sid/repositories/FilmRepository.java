package org.sid.repositories;

import java.util.List;
import java.util.Optional;

import org.sid.models.FilmModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vince
 *Créer les requêtes en BDD
 */
public interface FilmRepository extends MongoRepository<FilmModel, String> {
	public List<FilmModel> findAll();
	public Optional<FilmModel> findAllByGenre(String genre);
	public FilmModel findAllByTitre(String titre);
}

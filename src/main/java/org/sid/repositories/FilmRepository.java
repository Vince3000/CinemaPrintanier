package org.sid.repositories;

import java.util.List;
import org.sid.models.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author vince
 *Créer les requêtes en BDD
 */
public interface FilmRepository extends MongoRepository<Film, String> {
	public List<Film> findAll();
	public List<Film> findAllByGenre(String genre);
	public Film findAllByTitre(String titre);
}

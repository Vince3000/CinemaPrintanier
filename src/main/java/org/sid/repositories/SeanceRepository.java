package org.sid.repositories;

import java.util.List;

import org.sid.models.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeanceRepository extends MongoRepository<Seance, String> {
	public List<Seance> findAll();
	public List<Seance> findAllByType(String type);
	public List<Seance> findByFilmGenre(String genre);
}

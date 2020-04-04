package org.sid.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.sid.models.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeanceRepository extends MongoRepository<Seance, String> {
	public List<Seance> findAll();
	public List<Seance> findAllByType(String type);
	public List<Seance> findByDateBetween(LocalDateTime debut, LocalDateTime fin);
	public Optional<Seance> findByFilmTitre(String titre);
	public Optional<List<Seance>> findByFilmGenre(String genre);
	public Optional<List<Seance>> findByFilmAgeLimite(int age);
}

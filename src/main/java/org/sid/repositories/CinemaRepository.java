package org.sid.repositories;

import java.util.List;
import java.util.Optional;

import org.sid.models.Cinema;
import org.sid.models.Salle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CinemaRepository extends MongoRepository<Cinema, String> {
	public List<Cinema> findAll();
	public Optional<Cinema> findById(String id);
	public Salle save(Salle s);
}

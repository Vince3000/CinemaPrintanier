package org.sid.repositories;

import java.util.List;

import org.sid.models.Salle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalleRepository extends MongoRepository<Salle, String> {
	public List<Salle> findAll();
}

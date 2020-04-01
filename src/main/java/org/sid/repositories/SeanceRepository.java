package org.sid.repositories;

import java.util.List;

import org.sid.models.SeanceModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeanceRepository extends MongoRepository<SeanceModel, String> {
	public List<SeanceModel> findAll();
}

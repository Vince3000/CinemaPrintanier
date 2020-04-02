package org.sid.repositories;

import java.util.List;

import org.sid.models.Assister;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssisterRepository extends MongoRepository<Assister, String> {
	public List<Assister> findAll();
}

package org.sid.repositories;

import java.util.List;

import org.sid.models.SalleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalleRepository extends MongoRepository<SalleModel, String> {
	public List<SalleModel> findAll();
}

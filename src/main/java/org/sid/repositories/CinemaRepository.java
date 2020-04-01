package org.sid.repositories;

import java.util.List;

import org.sid.models.CinemaModel;
import org.sid.models.SalleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CinemaRepository extends MongoRepository<CinemaModel, String> {
	public List<CinemaModel> findAll();
	public SalleModel save(SalleModel s);
}

package org.sid.repositories;

import java.util.List;

import org.sid.models.FilmModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<FilmModel, String> {
	public List<FilmModel> findAll();
}

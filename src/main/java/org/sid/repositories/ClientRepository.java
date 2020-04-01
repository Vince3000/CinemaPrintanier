package org.sid.repositories;

import java.util.List;

import org.sid.models.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientModel, String> {
	public List<ClientModel> findAll();
}

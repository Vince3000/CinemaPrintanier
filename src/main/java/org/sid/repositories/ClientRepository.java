package org.sid.repositories;

import java.util.List;

import org.sid.models.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
	public List<Client> findAll();
}

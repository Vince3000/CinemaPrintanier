package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.Client;

public interface ClientService {
	public List<Client> findAll();
	public Optional<Client> findById(String id);
	public Client save(Client s);
	public void delete(String id);
}

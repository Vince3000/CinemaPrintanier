package org.sid.services;

import java.util.List;

import org.sid.models.Client;

public interface ClientService {
	public List<Client> findAll();
	public Client findById(String id);
	public Client save(Client s);
	public void delete(String id);
}

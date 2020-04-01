package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.ClientModel;

public interface ClientService {
	public List<ClientModel> findAll();
	public Optional<ClientModel> findById(String id);
	public ClientModel save(ClientModel s);
	public void delete(String id);
}

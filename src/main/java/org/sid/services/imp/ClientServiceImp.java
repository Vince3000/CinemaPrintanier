package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Client;
import org.sid.repositories.ClientRepository;
import org.sid.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientServiceImp implements ClientService {
	@Autowired
	private ClientRepository client;
	@Override
	public List<Client> findAll() {
		return this.client.findAll();
	}
	@Override
	public Client findById(String id) {
		Optional<Client> optional =  this.client.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id "+id+" n'est pas valide pour une client");
	}
	@Override
	public Client save(Client s) {
		return this.client.save(s);
	}
	@Override
	public void delete(String id) {
		this.client.deleteById(id);
	}

}

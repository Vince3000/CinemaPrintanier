package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.Client;
import org.sid.repositories.ClientRepository;
import org.sid.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {
	@Autowired
	private ClientRepository client;
	@Override
	public List<Client> findAll() {
		return this.client.findAll();
	}
	@Override
	public Optional<Client> findById(String id) {
		// TODO Auto-generated method stub
		return this.client.findById(id);
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

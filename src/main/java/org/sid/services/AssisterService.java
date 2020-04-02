package org.sid.services;

import java.util.Optional;

import org.sid.models.Assister;

public interface AssisterService {
	Optional<Assister> findById(String id);
	//Assister addClient(String idAssister, String idclient);
	public Assister update(Assister a);
	//Assister addClient(String idseance, String idclient);
}

package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.Salle;

public interface SalleService {
	public Salle save(Salle s);
	public Optional<Salle> findById(String id);
	public List<Salle> findAll();
}

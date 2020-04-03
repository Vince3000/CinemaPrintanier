package org.sid.services;

import java.util.List;

import org.sid.models.Salle;

public interface SalleService {
	public Salle save(Salle s);
	public Salle findById(String id);
	public List<Salle> findAll();
}

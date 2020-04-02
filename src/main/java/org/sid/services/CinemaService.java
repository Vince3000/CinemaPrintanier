package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.Cinema;

public interface CinemaService {
	public List<Cinema> findAll();
	public Optional<Cinema> findById(String id);
	public Cinema save(Cinema s);
	public void delete(String id);
	//public CinemaDto save(CinemaDto dto);
}

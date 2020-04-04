package org.sid.services;

import java.util.List;

import org.sid.models.Cinema;

public interface CinemaService {
	public List<Cinema> findAll();
	public Cinema findById(String id);
	public Cinema saveCinema(Cinema s);
	public void delete(String id);
}

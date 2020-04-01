package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.dto.CinemaDto;
import org.sid.models.CinemaModel;

public interface CinemaService {

	public List<CinemaModel> findAll();
	public Optional<CinemaModel> findById(String id);
	public CinemaModel save(CinemaModel s);
	public void delete(String id);
	public CinemaDto save(CinemaDto dto);
}

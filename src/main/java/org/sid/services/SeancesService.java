package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.models.SeanceModel;

public interface SeancesService {
	public List<SeanceModel> findAll();
	public Optional<SeanceModel> findById(String id);
	public SeanceModel save(SeanceModel s);
	public void delete(String id);
}

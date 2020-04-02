package org.sid.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.sid.models.Seance;

public interface SeancesService {
	public List<Seance> findAll();
	public Optional<Seance> findById(String id);
	public List<Seance> findByType(String type);
	public List<Seance> findByFilm(String nomfilm);
	public List<Seance> findByHoraire(LocalDateTime debut, LocalDateTime fin);
	public Seance addClient(String idseance,String idAssister);
	//public List<Seance> findByGenre(String genre);
	public Seance save(Seance s);
	public void delete(String id);
	public Seance update(Seance s);
}

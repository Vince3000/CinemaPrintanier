package org.sid.services;

import java.time.LocalDateTime;
import java.util.List;

import org.sid.models.Seance;

public interface SeancesService {
	public List<Seance> findAll();
	public Seance findById(String id);
	public List<Seance> findByType(String type);
	public List<Seance> findByHoraire(LocalDateTime debut, LocalDateTime fin);
	public Seance save(Seance s);
	public void delete(String id);
	public Seance update(Seance s);
	public int recetteSeance (String idSeance);
	public Seance addClient(String idSeance,String idClient);
	public int findPlaceSeance(String id);
	public Seance seanceByFilm(String titre);
}

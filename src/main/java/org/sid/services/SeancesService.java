package org.sid.services;

import java.util.List;

import org.sid.models.Seance;

public interface SeancesService {
	public List<Seance> findAll();
	public Seance findById(String id);
	public List<Seance> findByType(String type);
	public List<Seance> findByHoraire(String debut, String fin);
	public Seance save(Seance s);
	public void delete(String id);
	public Seance update(Seance s);
	public int recetteSeance (String idSeance);
	public Seance addClient(String idSeance,String idClient);
	public int findPlaceSeance(String id);
	public Seance seanceByFilm(String titre);
	public List<Seance> seanceByGenre(String genre);
	public List<Seance> seanceByAge(String age);
}

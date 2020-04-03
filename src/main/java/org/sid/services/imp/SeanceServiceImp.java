package org.sid.services.imp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sid.models.Assister;
import org.sid.models.Client;
import org.sid.models.Film;
import org.sid.models.Salle;
import org.sid.models.Seance;
import org.sid.repositories.SeanceRepository;
import org.sid.services.ClientService;
import org.sid.services.FilmService;
import org.sid.services.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SeanceServiceImp implements SeancesService {
	@Autowired
	private SeanceRepository seance;
	@Autowired
	private ClientService clientService;
	@Autowired
	private FilmService filmService;

	@Override
	public List<Seance> findAll(){
		return this.seance.findAll();
	}

	@Override
	public Seance findById(String id){
		Optional<Seance> optional =  this.seance.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id "+id+" n'est pas valide pour une seance");
	}

	@Override
	public Seance save(Seance s) {
		return this.seance.save(s);
	}

	@Override
	public Seance update(Seance s) {
		return this.seance.save(s);
	}

	@Override
	public void delete(String id) {
		this.seance.deleteById(id);
	}

	@Override
	public List<Seance> findByHoraire(LocalDateTime debut, LocalDateTime fin) {
		return this.seance.findByDateBetween(debut, fin);
	}

	@Override
	public int recetteSeance (String idSeance) {
		Seance seance = this.findById(idSeance);
		int cumul = 0;
		for (Assister s : seance.getClient()) {
			cumul+= s.getPrix();
		}
		return cumul;
	}

	@Override
	public Seance seanceByFilm(String titre) {
		Film film = this.filmService.findByTitre(titre);
		return this.seance.findByFilm(film);
	}

	@Override
	public int findPlaceSeance(String id) {
		Seance seance = this.findById(id);
		Salle salle = seance.getSalle();
		List<Assister> sean = new ArrayList<>();
		for (Assister s : seance.getClient()) {
			sean.add(s);
		}
		return salle.getPlace()-sean.size();
	}

	//@Override
	public Seance addClient(String idSeance, String idClient) {
		// TODO Auto-generated method stub
		Seance seance = this.findById(idSeance);
		Client client = this.clientService.findById(idClient);
		Assister assister = new Assister();
		assister.setPrix(this.prix(seance, client));
		assister.setClient(client);
		seance.getClient().add(assister);
		return this.save(seance);
	}

	private float prix (Seance ps, Client pc) {
		float result = 10; //prix par default
		System.out.println(ps.getType());

		if(ps.getType().equals("3D")) result+=3.0f;
		else if(ps.getType().equals("IMAX")) result+=6.0f;
		else if(ps.getType().equals("4DX")) result+=8.0f;

		if((LocalDate.now().getYear()- pc.getNaissance().getYear()) <10) result-=4.0f;

		if(pc.isEtudiant()) result-=2.0f;
		return result;
	}

	/*---------------------------------------EXPERIMENTALE---------------------------------------------*/
	@Override
	public List<Seance> findByType(String type){
		return this.seance.findAllByType(type);
	}

	@Override
	public Seance findByFilm(Film titreFilm) {
		return this.seance.findByFilm(titreFilm);
	}

	@Override
	public List<Seance> findSeanceByGenreFilm(String genre) {
		// TODO Auto-generated method stub
		return null;
	}
}

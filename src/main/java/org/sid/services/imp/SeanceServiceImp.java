package org.sid.services.imp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sid.models.Assister;
import org.sid.models.Client;
import org.sid.models.Film;
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
	public List<Seance> findByHoraire(String debut, String fin) {
		LocalDateTime min = LocalDateTime.of(LocalDate.now(),LocalTime.parse(debut));
		LocalDateTime max = LocalDateTime.of(LocalDate.now(),LocalTime.parse(fin));
		List<Seance> seance = this.seance.findByDateBetween(min, max);
		return seance;
	}

	@Override
	public int recetteSeance (String idSeance) {
		Seance seance = this.findById(idSeance);
		int cumul = 0;
		for (Assister s : seance.getClients()) {
			cumul+= s.getPrix();
		}
		return cumul;
	}

	@Override
	public Seance seanceByFilm(String titre) {
		Film film = this.filmService.findByTitre(titre);
		return this.seance.findByFilmId(film.getId());
	}

	@Override
	public Seance seanceByFilmId(String id) {
		Film film = this.filmService.findById(id);
		return this.seance.findByFilmId(film.getId());
	}

	@Override
	public List<Seance> seanceByGenre(String genre) {
		List<Film> film = this.filmService.findFilmByGenre(genre);
		List<Seance> seance = new ArrayList<>();
		for (Film f : film) {
			seance.add(this.seance.findByFilmId(f.getId()));
		}
		return seance;
	}

	@Override
	public List<Seance> seanceByAge(String age) {
		int i = Integer.parseInt(age);
		List<Film> film = this.filmService.findAll();
		List<Seance> seance = new ArrayList<>();
		for (Film f : film) {
			if(f.getAgeLimite()<=i) seance.add(this.seance.findByFilmId(f.getId()));
		}
		return seance;
	}

	@Override
	public int findPlaceSeance(String id) {
		Seance seance = this.findById(id);
		List<Assister> assist = seance.getClients();
		return seance.getSalle().getPlace()-assist.size();
	}

	//@Override
	public List<String> addClient(String idSeance, String idClient) {
		// TODO Auto-generated method stub
		Seance seance = this.findById(idSeance);
		Client client = this.clientService.findById(idClient);
		if((LocalDate.now().getYear() - client.getNaissance().getYear()) >= seance.getFilm().getAgeLimite()) {
			if(this.findPlaceSeance(idSeance)>0) {
				Assister assister = new Assister();
				assister.setPrix(this.prix(seance, client));
				assister.setClient(client);
				seance.getClients().add(assister);
				this.save(seance);
				return recap(idSeance,idClient);
			} throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plus de place pour la séance ");
		}throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ce film est interdit au moins de " + seance.getFilm().getAgeLimite() + " ans");
	}

	//@Override
	public List<String> recap(String idSeance, String idClient){
		Seance seance = this.findById(idSeance);
		Client client = this.clientService.findById(idClient);
		String titre = seance.getFilm().getTitre();
		String salle = seance.getSalle().getNom();
		List<String> s = new ArrayList<>();
		s.add("Titre : " + titre);
		s.add("Salle :" + salle);
		s.add("Le " + seance.getDate().getDayOfMonth() +"/" + seance.getDate().getMonthValue()+"/"+seance.getDate().getYear() + 
				" à " + seance.getDate().getHour() + ":" + seance.getDate().getMinute());
		s.add("Prix : "+this.prix(seance, client)+"€");
		return s;
	}

	private float prix (Seance ps, Client pc) {
		float result = 10; //prix par default
		if(ps.getType().equals("3D")) result+=3.0f;
		else if(ps.getType().equals("IMAX")) result+=6.0f;
		else if(ps.getType().equals("4DX")) result+=8.0f;

		if((LocalDate.now().getYear()- pc.getNaissance().getYear()) <10) result-=4.0f;

		if(pc.isEtudiant()) result-=2.0f;
		return result;
	}

	@Override
	public List<Seance> findByType(String type){
		return this.seance.findAllByType(type);
	}
}

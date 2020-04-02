package org.sid.services.imp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.sid.models.Film;
import org.sid.models.Seance;
import org.sid.repositories.FilmRepository;
import org.sid.repositories.SeanceRepository;
//import org.sid.services.FilmService;
import org.sid.services.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Add;
import org.springframework.stereotype.Service;

@Service
public class SeanceServiceImp implements SeancesService {
	@Autowired
	private SeanceRepository seance;
	@Autowired
	private FilmRepository film;
	@Override
	public List<Seance> findAll(){
		return this.seance.findAll();
	}
	@Override
	public Optional<Seance> findById(String id){
		return this.seance.findById(id);
	}
	@Override
	public List<Seance> findByType(String type){
		return this.seance.findAllByType(type);
	}
//	@Override
//	public List<Seance> findByGenre(String genre) {
//		// TODO Auto-generated method stub
//		return this.seance.findByFilmGenre(genre);
//	}
	@Override
	public List<Seance> findByFilm(String nomfilm){
		Film f = film.findAllByTitre(nomfilm);
		return seance.findByFilm(f);
	}
	@Override
	public Seance save(Seance s) {
		return this.seance.save(s);
	}
	@Override
	public void delete(String id) {
		this.seance.deleteById(id);
	}
	//	@Override
	//	public Seance addClient(String idseance,String idAssister) {
	//
	//		if (!this.findById(idseance).isPresent() || !AssisterService.findById(idAssister).isPresent())
	//			return null;
	//
	//		Seance s = this.findById(idseance).get();
	//		Optional<Assister> a = AssisterService.findById(idAssister);
	//		Assister assist = a.get();
	//		s.getClient().add(assist);
	//		//this.update(s);
	//
	//		return s;
	//	}
	@Override
	public List<Seance> findByHoraire(LocalDateTime debut, LocalDateTime fin) {
		// TODO Auto-generated method stub
		return null;
	}

}

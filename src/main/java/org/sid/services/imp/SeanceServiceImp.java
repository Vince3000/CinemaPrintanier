package org.sid.services.imp;

import java.util.List;
import java.util.Optional;

import org.sid.models.SeanceModel;
import org.sid.repositories.SeanceRepository;
import org.sid.services.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SeanceServiceImp implements SeancesService {
	@Autowired
	private SeanceRepository seance;
	@Override
	public List<SeanceModel> findAll(){
		return this.seance.findAll();
	}
	@Override
	public Optional<SeanceModel> findById(String id){
		return this.seance.findById(id);
	}	
	@Override
	public SeanceModel save(SeanceModel s) {
		return this.seance.save(s);
	}
	@Override
	public void delete(String id) {
		this.seance.deleteById(id);
	}
}

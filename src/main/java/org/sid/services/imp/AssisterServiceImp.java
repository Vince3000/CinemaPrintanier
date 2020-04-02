package org.sid.services.imp;

import java.time.LocalDate;
import java.util.Optional;

import org.sid.models.Assister;
import org.sid.models.Client;
import org.sid.models.Seance;
import org.sid.repositories.AssisterRepository;
import org.sid.services.AssisterService;
//import org.sid.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssisterServiceImp implements AssisterService{
	@Autowired
	private AssisterRepository assister;
	//@Autowired
	//private ClientService ClientService;
	@Override
	public Optional<Assister> findById(String id) {
		return this.assister.findById(id);
	}
	@Override
	public Assister update(Assister a) {
		return this.assister.save(a);
	}

//	@Override
//	public Assister addClient(String idseance, String idclient) {
//		
//		Assister assist = null;
//		
//		Seance seance = this.findById(idseance).get();//findById(idseance).get();
//		
//		Client c = this.ClientService.findById(idclient).get();
//		assist = new Assister(this.prix(seance, c),c);
//		this.assister.save(assist);
//		
//		return assist;
//	}
	//Pas de @Override ce n'est pas utilisé dasn le controller
	@SuppressWarnings("unused")
	private float prix (Seance ps, Client pc) {
		float result = 10; //prix par default
		if(ps.getType()=="3D") 
		{
			result+=3.0f;
		}else if(ps.getType()=="IMAX") 
		{
			result+=6.0f;
		}else if(ps.getType()=="4DX") 
		{
			result+=8.0f;
		}

		if(pc.getNaissance().compareTo(LocalDate.now())<10) {
			result-=4.0f;
		}
		if(pc.isEtudiant()) {
			result-=2.0f;
		}
		return result;
	}
}

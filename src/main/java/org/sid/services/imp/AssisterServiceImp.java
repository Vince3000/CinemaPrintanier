package org.sid.services.imp;

import java.util.Optional;

import org.sid.models.Assister;
import org.sid.repositories.AssisterRepository;
import org.sid.services.AssisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AssisterServiceImp implements AssisterService{
	@Autowired
	private AssisterRepository assister;

	@Override
	public Assister findById(String id) {
		Optional<Assister> optional =  this.assister.findById(id);
		if (optional.isPresent()) return optional.get();
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'id "+id+" n'est pas valide cet assister");
	}

	@Override
	public Assister update(Assister a) {
		return this.assister.save(a);
	}
}

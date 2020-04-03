package org.sid.services;

import org.sid.models.Assister;

public interface AssisterService {
	Assister findById(String id);
	public Assister update(Assister a);
}

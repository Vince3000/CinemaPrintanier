package org.sid.models;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Assister {
	@Id
	String id;
	float prix;
	@DBRef
	private Seance salle;
	@DBRef
	private List<Client> client;
}

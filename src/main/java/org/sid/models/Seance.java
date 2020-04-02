package org.sid.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor

public class Seance {
	@Id
	String id;
	LocalDateTime date;
	String type;
	int duree;
	private Salle salle;
	private  List<Assister> Client = new ArrayList<>();
	@DBRef
	private Film film;

}

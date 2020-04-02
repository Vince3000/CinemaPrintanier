package org.sid.models;

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

public class Film {
	@Id
	private String id;
	private String titre;
	private int duree_minute;
	private int age_limite;
	private String genre;
	private String visa;
	@DBRef
	private Seance seance;
}
